package com.jfoltyn.forsetiserver.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService {

   @Resource
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Resource
   private UserRepository userRepository;

   public void signUpUser(User user) {
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      userRepository.save(user);
   }

   public User getUser(String username) {
      return userRepository.findByUsername(username);
   }
}
