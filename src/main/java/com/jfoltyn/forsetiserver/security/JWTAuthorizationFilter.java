package com.jfoltyn.forsetiserver.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static com.jfoltyn.forsetiserver.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

   public JWTAuthorizationFilter(AuthenticationManager authManager) {
      super(authManager);
   }

   @Override
   protected void doFilterInternal(HttpServletRequest req,
                                   HttpServletResponse res,
                                   FilterChain chain) throws IOException, ServletException {
      String header = req.getHeader(AUTHORIZATION_HEADER);

      if (header == null || !header.startsWith(TOKEN_PREFIX)) {
         chain.doFilter(req, res);
         return;
      }

      UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

      SecurityContextHolder.getContext().setAuthentication(authentication);
      chain.doFilter(req, res);
   }

   private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
      String token = request.getHeader(AUTHORIZATION_HEADER);
      if (token != null) {
         // parse the token.
         Claims claims = JWTExtractor.extractClaims(token);
         return new UsernamePasswordAuthenticationToken(claims.getSubject(),
               null,
               Collections.singletonList(new SimpleGrantedAuthority(claims.get(ROLE_PAYLOAD_KEY, String.class))));
      }
      return null;
   }
}