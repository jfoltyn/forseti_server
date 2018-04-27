package com.jfoltyn.forsetiserver.controllers;

import com.jfoltyn.forsetiserver.user.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController {
   @PostMapping("/login")
   public void login(@RequestBody User user) {
      throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
   }

   @PostMapping("/logout")
   public void logout() {
      throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
   }
}
