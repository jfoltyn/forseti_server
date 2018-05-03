package com.jfoltyn.forsetiserver.controllers;

import com.jfoltyn.forsetiserver.user.User;
import com.jfoltyn.forsetiserver.user.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.USER;
import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.USER_COMMENT;
import static com.jfoltyn.forsetiserver.security.JWTUsernameExtractor.extractUsername;
import static com.jfoltyn.forsetiserver.security.SecurityConstants.AUTHORIZATION_HEADER;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class UserRestController {

   @Resource
   private UserService userService;

   @RequestMapping(value = USER, method = GET)
   public User user(@RequestHeader(AUTHORIZATION_HEADER) String jwtToken) {
      String username = extractUsername(jwtToken);
      User user = userService.getUser(username);
      return user;
   }

   @RequestMapping(value = USER_COMMENT + "{commentId}", method = DELETE)
   public User deleteComment(@PathVariable("commentId") long commentId, @RequestHeader(AUTHORIZATION_HEADER) String jwtToken) {
      String username = extractUsername(jwtToken);
      User user = userService.deleteComment(username, commentId);
      return user;
   }
}
