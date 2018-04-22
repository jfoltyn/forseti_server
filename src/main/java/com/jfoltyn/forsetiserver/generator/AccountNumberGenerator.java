package com.jfoltyn.forsetiserver.generator;

import com.jfoltyn.forsetiserver.accountnumber.AccountNumber;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

import static com.jfoltyn.forsetiserver.generator.ConstantsRepository.getRandomElement;
import static com.jfoltyn.forsetiserver.generator.ConstantsRepository.sortCodes;
import static java.lang.Math.random;

@Component
public class AccountNumberGenerator {

   private static final String MAX_NUMBER_REPRESENTATION = "9999 9999 9999 9999";
   private static final String MAX_NUMBER_ACTUAL = MAX_NUMBER_REPRESENTATION.replace(" ", "");

   private static final BigInteger CHECKSUM_DIVIDOR = new BigInteger("97");
   private static final String PL = "2521";

   private static final String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

   public AccountNumber generate() {
      return getRandomAccountNumber();
   }

   private AccountNumber getRandomAccountNumber() {
      AccountNumber accountNumber = new AccountNumber();
      accountNumber.setAccountNumber(createValidAccountNumber());
      return accountNumber;
   }

   private String createValidAccountNumber() {
      String sortCode = String.valueOf(getRandomElement(sortCodes()));

      String bankIndividualAccountNumber = generateRandomNumber(16);

      BigInteger fullIBANBeforeChecksum = new BigInteger(sortCode + bankIndividualAccountNumber + PL + "00");
      int checksum = 98 - fullIBANBeforeChecksum.mod(CHECKSUM_DIVIDOR).intValue();

      return String.valueOf(checksum) + sortCode + bankIndividualAccountNumber;
   }

   private String generateRandomNumber(int length) {
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < length; i++) {
         result.append(digits[(int) (random() * 10)]);
      }
      return result.toString();
   }
}
