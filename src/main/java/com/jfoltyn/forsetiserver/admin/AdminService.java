package com.jfoltyn.forsetiserver.admin;

import com.jfoltyn.forsetiserver.accountnumber.AccountNumber;
import com.jfoltyn.forsetiserver.accountnumber.AccountNumberRepository;
import com.jfoltyn.forsetiserver.accountnumber.Comment;
import com.jfoltyn.forsetiserver.user.User;
import com.jfoltyn.forsetiserver.user.UserRepository;
import com.jfoltyn.forsetiserver.user.exception.UserDoesntExistsException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
}
