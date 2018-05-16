package com.jfoltyn.forsetiserver.controllers;

import com.jfoltyn.forsetiserver.accountnumber.AccountNumber;
import com.jfoltyn.forsetiserver.accountnumber.AccountNumberService;
import com.jfoltyn.forsetiserver.admin.AdminService;
import com.jfoltyn.forsetiserver.admin.UsersList;
import com.jfoltyn.forsetiserver.user.User;
import com.jfoltyn.forsetiserver.user.UserService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.*;
import static com.jfoltyn.forsetiserver.security.SecurityConstants.AUTHORIZATION_HEADER;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class AdminRestController {

   @Resource
   private AdminService adminService;

   @Resource
   private UserService userService;

   @Resource
   private AccountNumberService accountNumberService;

   @RequestMapping(value = ADMIN_USER + "{username}", method = GET)
   @ApiImplicitParam(name = AUTHORIZATION_HEADER, value = AUTHORIZATION_HEADER, required = true, dataType = "String", paramType = "header")
   public User getUser(@PathVariable("username") String username) {
      return adminService.getUser(username);
   }

   @RequestMapping(value = ADMIN_USER + "{username}", method = DELETE)
   @ApiImplicitParam(name = AUTHORIZATION_HEADER, value = AUTHORIZATION_HEADER, required = true, dataType = "String", paramType = "header")
   public UsersList deleteUser(@PathVariable("username") String username) {
      adminService.removeUser(username);
      return adminService.getUsersList();
   }

   @RequestMapping(value = ADMIN_NUMBER + "{number}/" + COMMENT + "{commentId}" , method = DELETE)
   @ApiImplicitParam(name = AUTHORIZATION_HEADER, value = AUTHORIZATION_HEADER, required = true, dataType = "String", paramType = "header")
   public AccountNumber deleteAccountNumberComment(@PathVariable("number") String number, @PathVariable("commentId") String commentId) {
      return adminService.deleteAccountNumberComment(number, commentId);
   }

   @RequestMapping(value = ADMIN_USER + "{username}/" + COMMENT + "{commentId}", method = DELETE)
   @ApiImplicitParam(name = AUTHORIZATION_HEADER, value = AUTHORIZATION_HEADER, required = true, dataType = "String", paramType = "header")
   public User deleteComment(@PathVariable("username") String username ,@PathVariable("commentId") long commentId) {
      return userService.deleteComment(username, commentId);
   }
}
