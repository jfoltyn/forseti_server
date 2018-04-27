package com.jfoltyn.forsetiserver.security;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.API;

public interface SecurityConstants {
   String SECRET = "SecretKeyToGenJWTs";
   long EXPIRATION_TIME = 864_000_000; // 10 days
   String TOKEN_PREFIX = "Bearer ";
   String HEADER_STRING = "Authorization";
}
