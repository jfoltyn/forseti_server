package com.jfoltyn.forsetiserver.security;

public interface SecurityConstants {
   String SECRET = "SecretKeyToGenJWTs";
   long EXPIRATION_TIME = 864_000_000; // 10 days
   String TOKEN_PREFIX = "Bearer ";
   String AUTHORIZATION_HEADER = "Authorization";

   String ROLE = "ROLE_";
   String USER = "USER";
   String ADMIN = "ADMIN";
}
