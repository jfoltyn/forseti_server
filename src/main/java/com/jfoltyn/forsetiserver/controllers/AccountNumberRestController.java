package com.jfoltyn.forsetiserver.controllers;

import com.jfoltyn.forsetiserver.accountnumber.AccountNumber;
import com.jfoltyn.forsetiserver.accountnumber.AccountNumberService;
import com.jfoltyn.forsetiserver.accountnumber.Thumb;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.ACCOUNT_NUMBER;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class AccountNumberRestController {

   @Resource
   private AccountNumberService accountNumberService;

   @RequestMapping(value = ACCOUNT_NUMBER + "{number}", method = GET)
   public AccountNumber getAccountNumberInfo(@PathVariable("number") String number) {
      return accountNumberService.getAccountNumberInfo(number);
   }

   @RequestMapping(value = ACCOUNT_NUMBER + "{number}", method = PUT)
   public AccountNumber addAccountNumberThumb(@PathVariable("number") String number, @RequestParam("username") String username, @RequestParam("thumb") Thumb thumb) {
      return accountNumberService.addAccountNumberThumb(number, username, thumb);
   }

}
