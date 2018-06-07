package com.jfoltyn.forsetiserver.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoltyn.forsetiserver.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.jfoltyn.forsetiserver.security.SecurityConstants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
   private AuthenticationManager authenticationManager;

   public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
      this.authenticationManager = authenticationManager;
   }

   @Override
   public Authentication attemptAuthentication(HttpServletRequest req,
                                               HttpServletResponse res) throws AuthenticationException {
      try {
         User creds = new ObjectMapper()
            .readValue(req.getInputStream(), User.class);

         return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
               creds.getUsername(),
               creds.getPassword(),
               new ArrayList<>())
         );
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   protected void successfulAuthentication(HttpServletRequest req,
                                           HttpServletResponse res,
                                           FilterChain chain,
                                           Authentication auth) throws IOException, ServletException {
      Claims claims = getClaims(auth);

      String token = Jwts.builder()
         .setClaims(claims)
         .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
         .compact();

      res.addHeader(AUTHORIZATION_HEADER, TOKEN_PREFIX + token);

      boolean isAdmin = claims.get(ROLE_PAYLOAD_KEY, String.class).contains(ADMIN);
      String responseJson = buildResponseBody(claims.getSubject(), isAdmin, token);

      res.setContentType(APPLICATION_JSON_VALUE);
      res.getWriter().write(responseJson);
   }

   private Claims getClaims(Authentication auth) {
      Claims claims = Jwts.claims();

      claims.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME));

      String username = ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername();
      claims.setSubject(username);

      String role = ((SimpleGrantedAuthority) auth.getAuthorities().toArray()[0]).getAuthority();
      claims.put(ROLE_PAYLOAD_KEY, role);
      return claims;
   }

   private String buildResponseBody(String username, boolean isAdmin, String token) throws JsonProcessingException {
      Map<String, String> response = new HashMap<>();
      response.put("username", username);
      response.put("isAdmin", String.valueOf(isAdmin));
      response.put(AUTHORIZATION_HEADER, TOKEN_PREFIX + token);
      return new ObjectMapper().writeValueAsString(response);
   }
}