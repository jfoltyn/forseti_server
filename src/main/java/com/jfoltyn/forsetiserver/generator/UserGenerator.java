package com.jfoltyn.forsetiserver.generator;

import com.jfoltyn.forsetiserver.user.User;
import org.springframework.stereotype.Component;

import static com.jfoltyn.forsetiserver.generator.ConstantsRepository.*;
import static java.lang.Math.random;

@Component
public class UserGenerator {

   public User generate() {
      return getRandomUser();
   }

   private User getRandomUser() {
      boolean male = random() > 0.5;
      User user = new User();
      if (male) {
         user.setFirstName(getRandomElement(maleNames()));
         user.setLastName(getRandomElement(maleSurnames()));
      } else {
         user.setFirstName(getRandomElement(femaleNames()));
         user.setLastName(getRandomElement(femaleSurnames()));
      }
      user.setEmail(user.getFirstName() + "." + user.getLastName() + "@gmail.com");
      return user;
   }
}
