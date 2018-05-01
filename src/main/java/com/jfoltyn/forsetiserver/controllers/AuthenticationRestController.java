package com.jfoltyn.forsetiserver.controllers;

import com.jfoltyn.forsetiserver.security.UserCredentials;
import com.jfoltyn.forsetiserver.user.User;
import com.jfoltyn.forsetiserver.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.SIGN_UP;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AuthenticationRestController {

   @Resource
   private UserService userService;

   @RequestMapping(value = SIGN_UP, method = POST)
   public void signUp(@RequestBody UserCredentials userCredentials) {
      userService.signUpUser(userCredentials);
   }

   @PostMapping("/login")
   public void login(@RequestBody UserCredentials userCredentials) {
      throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
   }
}
