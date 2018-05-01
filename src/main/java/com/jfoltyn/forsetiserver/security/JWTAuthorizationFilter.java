package com.jfoltyn.forsetiserver.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.jfoltyn.forsetiserver.security.SecurityConstants.AUTHORIZATION_HEADER;
import static com.jfoltyn.forsetiserver.security.SecurityConstants.TOKEN_PREFIX;

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
         String user = JWTUsernameExtractor.extractUsername(token);

         if (user != null) {
            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
         }
         return null;
      }
      return null;
   }
}