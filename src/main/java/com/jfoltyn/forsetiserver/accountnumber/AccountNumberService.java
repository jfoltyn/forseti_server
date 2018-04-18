package com.jfoltyn.forsetiserver.accountnumber;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AccountNumberService {

   @Resource
   private AccountNumberRepository accountNumberRepository;

   public AccountNumber getAccountNumberInfo(String number) {
      return accountNumberRepository.findAccountNumberByAccountNumber(number);
   }

   public AccountNumber addAccountNumberThumb(String number, ThumbDetails thumbDetails) {
      AccountNumber accountNumber = accountNumberRepository.findAccountNumberByAccountNumber(number);
      if (accountNumber == null) {
         accountNumber = new AccountNumber(number);
      }
      accountNumber.addThumb(thumbDetails);
      return accountNumberRepository.save(accountNumber);
   }
}