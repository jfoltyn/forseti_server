package com.jfoltyn.forsetiserver.controllers;

import com.jfoltyn.forsetiserver.accountnumber.AccountNumberService;
import com.jfoltyn.forsetiserver.admin.AdminService;
import com.jfoltyn.forsetiserver.admin.UsersList;
import com.jfoltyn.forsetiserver.user.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.ADMIN_USER;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
public class AdminRestController {

   @Resource
   private AdminService adminService;

   @Resource
   private UserService userService;

   @Resource
   private AccountNumberService accountNumberService;

   @RequestMapping(value = ADMIN_USER + "{username}", method = DELETE)
   public UsersList deleteUser(@PathVariable("username") String username) {
      adminService.removeUser(username);
      return adminService.getUsersList();
   }
}
