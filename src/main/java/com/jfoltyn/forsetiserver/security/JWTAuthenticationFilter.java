package com.jfoltyn.forsetiserver.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoltyn.forsetiserver.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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

      String username = ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername();
      String token = Jwts.builder()
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
            .compact();
      res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

      String responseJson = buildResponseBody(username, token);

      res.setContentType(APPLICATION_JSON_VALUE);
      res.getWriter().write(responseJson);
   }

   private String buildResponseBody(String username, String token) throws JsonProcessingException {
      Map<String, String> response = new HashMap<>();
      response.put("username", username);
      response.put("authorization", TOKEN_PREFIX + token);
      return new ObjectMapper().writeValueAsString(response);
   }
}