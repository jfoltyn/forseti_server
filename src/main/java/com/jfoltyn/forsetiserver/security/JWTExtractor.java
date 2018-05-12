package com.jfoltyn.forsetiserver.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import static com.jfoltyn.forsetiserver.security.SecurityConstants.SECRET;
import static com.jfoltyn.forsetiserver.security.SecurityConstants.TOKEN_PREFIX;

public class JWTExtractor {


   public static Claims extractClaims(String jwtToken) {
      return Jwts.parser()
            .setSigningKey(SECRET.getBytes())
            .parseClaimsJws(jwtToken.replace(TOKEN_PREFIX, ""))
            .getBody();
   }

   public static String extractUsername(String jwtToken) {
      return Jwts.parser()
            .setSigningKey(SECRET.getBytes())
            .parseClaimsJws(jwtToken.replace(TOKEN_PREFIX, ""))
            .getBody()
            .getSubject();
   }

}
