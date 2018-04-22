package com.jfoltyn.forsetiserver.generator;

import com.jfoltyn.forsetiserver.accountnumber.*;
import com.jfoltyn.forsetiserver.user.User;
import com.jfoltyn.forsetiserver.user.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jfoltyn.forsetiserver.generator.ConstantsRepository.getRandomElement;
import static java.lang.Math.random;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class GeneratorRestController {

   @Resource
   private UserGenerator userGenerator;

   @Resource
   private AccountNumberGenerator accountNumberGenerator;

   @Resource
   private CommentGenerator commentGenerator;


   @Resource
   private AccountNumberRepository accountNumberRepository;

   @Resource
   private UserRepository userRepository;

   @RequestMapping(value = "dev/generate", method = GET)
   public void generate(@RequestParam(value = "usersamount", defaultValue = "100") Integer usersAmount,
                        @RequestParam(value = "accountnumbersamount", defaultValue = "30") Integer accountNumbersAmount,
                        @RequestParam(value = "commentsamount", defaultValue = "400") Integer commentsAmount,
                        @RequestParam(value = "oldestactivitydate", defaultValue = "2017-01-01T00:00:00.000+0100") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") Date oldestActivityDate,
                        @RequestParam(value = "thumbssaturation", defaultValue = "0.2") Double thumbsSaturation) {

      List<Comment> comments = getComments(commentsAmount, oldestActivityDate);
      List<AccountNumber> accountNumbers = getAccountNumbers(accountNumbersAmount);
      List<User> users = getUsers(usersAmount);
      userRepository.saveAll(users);

      for (Comment commentToAssign : comments) {
         User user = getRandomElement(users);
         AccountNumber accountNumber = getRandomElement(accountNumbers);

         user.addComment(commentToAssign);
         accountNumber.addComment(user.getId(), commentToAssign);
      }

      for (AccountNumber accountNumber : accountNumbers) {
         for (User user : users) {
            if (random() < thumbsSaturation) {
               ThumbDetails thumbDetails = new ThumbDetails(getRandomThumb());
               user.addThumb(thumbDetails);
               accountNumber.addThumb(user.getId(), thumbDetails);
            }
         }
      }

      userRepository.saveAll(users);
      accountNumberRepository.saveAll(accountNumbers);
   }

   private List<User> getUsers(Integer usersAmount) {
      List<User> users = new ArrayList<>();
      for (int i = 0; i < usersAmount; i++) {
         users.add(userGenerator.generate());
      }
      return users;
   }

   private List<AccountNumber> getAccountNumbers(Integer accountNumbersAmount) {
      List<AccountNumber> accountNumbers = new ArrayList<>();
      for (int i = 0; i < accountNumbersAmount; i++) {
         accountNumbers.add(accountNumberGenerator.generate());
      }
      return accountNumbers;
   }

   private List<Comment> getComments(Integer commentsAmount, Date oldestActivityDate) {
      List<Comment> comments = new ArrayList<>();
      for (int i = 0; i < commentsAmount; i++) {
         comments.add(commentGenerator.generate(oldestActivityDate));
      }
      return comments;
   }

   private Thumb getRandomThumb() {
      Thumb thumb;
      if (random() < 0.5) {
         thumb = Thumb.UP;
      } else {
         thumb = Thumb.DOWN;
      }
      return thumb;
   }
}
