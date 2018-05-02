package com.jfoltyn.forsetiserver.controllers;

import com.jfoltyn.forsetiserver.accountnumber.AccountNumber;
import com.jfoltyn.forsetiserver.accountnumber.AccountNumberService;
import com.jfoltyn.forsetiserver.accountnumber.Thumb;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.ACCOUNT_NUMBER;
import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.ACCOUNT_NUMBER_COMMENT;
import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.ACCOUNT_NUMBER_THUMB;
import static com.jfoltyn.forsetiserver.security.JWTUsernameExtractor.extractUsername;
import static com.jfoltyn.forsetiserver.security.SecurityConstants.AUTHORIZATION_HEADER;
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

   @RequestMapping(value = ACCOUNT_NUMBER_THUMB + "{number}", method = PUT)
   public AccountNumber addAccountNumberThumb(@PathVariable("number") String number, @RequestParam("thumb") Thumb thumb, @RequestHeader(AUTHORIZATION_HEADER) String jwtToken) {
      String username = extractUsername(jwtToken);
      return accountNumberService.addAccountNumberThumb(number, username, thumb);
   }

   @RequestMapping(value = ACCOUNT_NUMBER_COMMENT + "{number}", method = PUT)
   public AccountNumber addAccountNumberComment(@PathVariable("number") String number, @RequestBody String comment, @RequestHeader(AUTHORIZATION_HEADER) String jwtToken) {
      String username = extractUsername(jwtToken);
      return accountNumberService.addAccountNumberComment(number, username, comment);
   }

}
