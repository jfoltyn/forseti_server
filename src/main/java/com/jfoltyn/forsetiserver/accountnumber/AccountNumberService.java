package com.jfoltyn.forsetiserver.accountnumber;

import com.jfoltyn.forsetiserver.user.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AccountNumberService {

   @Resource
   private AccountNumberRepository accountNumberRepository;

   @Resource
   private UserService userService;

   public AccountNumber getAccountNumberInfo(String number) {
      AccountNumber accountNumberDocument = accountNumberRepository.findAccountNumberByAccountNumber(number);
      if (accountNumberDocument == null) {
         accountNumberDocument = new AccountNumber(number);
      }
      return accountNumberDocument;
   }

   public AccountNumber addAccountNumberThumb(String number, String username, Thumb thumb) {
      ThumbDetails thumbDetails = new ThumbDetails(thumb);

      userService.addThumb(username, number, thumbDetails);

      AccountNumber accountNumber = accountNumberRepository.findAccountNumberByAccountNumber(number);
      if (accountNumber == null) {
         accountNumber = new AccountNumber(number);
      }
      accountNumber.addThumb(username, thumbDetails);
      return accountNumberRepository.save(accountNumber);
   }

   public AccountNumber addAccountNumberComment(String number, String username, String commentInput) {
      Comment comment = new Comment(commentInput);

      userService.addComment(username, number, comment);

      AccountNumber accountNumber = accountNumberRepository.findAccountNumberByAccountNumber(number);
      if (accountNumber == null) {
         accountNumber = new AccountNumber(number);
      }
      accountNumber.addComment(username, comment);
      return accountNumberRepository.save(accountNumber);
   }
}
