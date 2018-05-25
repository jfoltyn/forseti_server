package com.jfoltyn.forsetiserver.admin;

import com.jfoltyn.forsetiserver.accountnumber.AccountNumber;
import com.jfoltyn.forsetiserver.accountnumber.AccountNumberRepository;
import com.jfoltyn.forsetiserver.accountnumber.Comment;
import com.jfoltyn.forsetiserver.accountnumber.Thumb;
import com.jfoltyn.forsetiserver.accountnumber.ThumbDetails;
import com.jfoltyn.forsetiserver.user.User;
import com.jfoltyn.forsetiserver.user.UserRepository;
import com.jfoltyn.forsetiserver.user.exception.NoSuchAccountNumberException;
import com.jfoltyn.forsetiserver.user.exception.NoSuchThumbException;
import com.jfoltyn.forsetiserver.user.exception.UserDoesntExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

   @Resource
   private UserRepository userRepository;

   @Resource
   private AccountNumberRepository accountNumberRepository;

   public User getUser(String username) {
      User existingUser = userRepository.findByUsername(username);
      if (existingUser == null) {
         throw new UserDoesntExistsException();
      }
      return existingUser;
   }

   public User removeUser(String username) {
      User user = getUser(username);
      user.setRemoved(true);
      userRepository.save(user);

      updateAccountNumbersWhereUserHaveCommented(user);

      return user;
   }

   public UsersList getUsersList() {
      UsersList usersList = new UsersList();

      List<User> removedFalse = userRepository.findAllByIsRemovedFalse();
      List<User> removedTrue = userRepository.findAllByIsRemovedTrue();

      removedFalse.forEach(user -> usersList.getUsers().add(user.getUsername()));
      removedTrue.forEach(user -> usersList.getRemovedUsers().add(user.getUsername()));

      return usersList;
   }

   private void updateAccountNumbersWhereUserHaveCommented(User user) {
      List<String> accountNumbers = new ArrayList<>(user.getComments().keySet());
      for (String accountNumber : accountNumbers) {
         AccountNumber accountNumberDocument = accountNumberRepository.findAccountNumberByAccountNumber(accountNumber);
         List<Comment> commentsFromRemovedUser = accountNumberDocument.getComments().remove(user.getUsername());
         accountNumberDocument.getRemovedUsersComments().put(user.getUsername(), commentsFromRemovedUser);
         accountNumberRepository.save(accountNumberDocument);
      }
   }

   public AccountNumber deleteAccountNumberComment(String number, String commentId) {
      AccountNumber accountNumberWithCommentToDelete = accountNumberRepository.findAccountNumberByAccountNumber(number);

      accountNumberWithCommentToDelete.getComments().forEach((k, v) -> v.removeIf(comment -> comment.getId() == Long.valueOf(commentId)));

      return accountNumberRepository.save(accountNumberWithCommentToDelete);
   }

   public User deleteThumb(String username, String number, Thumb thumb) {
      User userWithThumbToDelete = userRepository.findByUsername(username);
      String thumbToDelete = null;

      for (Entry<String, ThumbDetails> entry : userWithThumbToDelete.getThumbsDetails().entrySet()) {
         if (entry.getKey().equals(number)) {
            thumbToDelete = number;
         }
      }

      if (thumbToDelete == null) {
         throw new NoSuchThumbException();
      }

      userWithThumbToDelete.getThumbsDetails().remove(number);

      AccountNumber accountNumberWithThumbToDelete = accountNumberRepository.findAccountNumberByAccountNumber(number);
      if (thumb.equals(Thumb.UP)) {
         accountNumberWithThumbToDelete.setThumbsUp(accountNumberWithThumbToDelete.getThumbsUp() - 1);
      } else {
         accountNumberWithThumbToDelete.setThumbsDown(accountNumberWithThumbToDelete.getThumbsDown() - 1);
      }

      accountNumberWithThumbToDelete.getThumbsDetails().remove(username);
      accountNumberRepository.save(accountNumberWithThumbToDelete);
      return userRepository.save(userWithThumbToDelete);
   }

   public void deleteAccountNumber(String number) {
      AccountNumber accountNumberToDelete = accountNumberRepository.findAccountNumberByAccountNumber(number);

      if(accountNumberToDelete == null){
         throw new NoSuchAccountNumberException();
      }

      accountNumberRepository.delete(accountNumberToDelete);
   }
}
