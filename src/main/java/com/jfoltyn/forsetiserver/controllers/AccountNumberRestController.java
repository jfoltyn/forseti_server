package com.jfoltyn.forsetiserver.controllers;

import com.jfoltyn.forsetiserver.domain.AccountNumber;
import org.springframework.web.bind.annotation.*;

import static com.jfoltyn.forsetiserver.controllers.ServiceDictionary.ACCOUNT_NUMBER;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class AccountNumberRestController {

   @RequestMapping(value = ACCOUNT_NUMBER + "/{number}", method = GET)
   public AccountNumber getAccountNumber(@PathVariable("number") String number){
      return AccountNumber.builder()
            .accountNumber(number)
            .thumbsUp(123)
            .thumbsDown(34)
            .build();
   }

}
