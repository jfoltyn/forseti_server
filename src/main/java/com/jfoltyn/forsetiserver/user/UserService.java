package com.jfoltyn.forsetiserver.user;

import com.jfoltyn.forsetiserver.security.UserCredentials;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService {

   @Resource
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Resource
   private UserRepository userRepository;

   public void signUpUser(UserCredentials userCredentials) {
      checkIfUserExists(userCredentials);
      User user = buildUser(userCredentials);
      userRepository.save(user);
   }

   private void checkIfUserExists(UserCredentials userCredentials) {
      User existingUser = userRepository.findByUsername(userCredentials.getUsername());
      if(existingUser != null){
         throw new UserAlreadyExistsException();
      }
   }

   private User buildUser(UserCredentials userCredentials) {
      User user = new User();
      user.setUsername(userCredentials.getUsername());
      user.setPassword(bCryptPasswordEncoder.encode(userCredentials.getPassword()));
      return user;
   }

   public User getUser(String username) {
      return userRepository.findByUsername(username);
   }
}
