package com.jfoltyn.forsetiserver.controllers;

import com.jfoltyn.forsetiserver.user.User;
import com.jfoltyn.forsetiserver.user.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.SIGN_UP;
import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.USER;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserRestController {

   @Resource
   private UserService userService;

   @RequestMapping(value = SIGN_UP, method = POST)
   public void signUp(@RequestBody User user) {
      userService.signUpUser(user);
   }

   @RequestMapping(value = USER + "{username}", method = GET)
   public User user(@PathVariable String username) {
      User user = userService.getUser(username);
      user.setPassword(null);
      return user;
   }
}
