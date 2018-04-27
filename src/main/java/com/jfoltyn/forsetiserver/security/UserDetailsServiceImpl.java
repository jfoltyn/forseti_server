package com.jfoltyn.forsetiserver.security;

import com.jfoltyn.forsetiserver.user.User;
import com.jfoltyn.forsetiserver.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

   @Resource
   private UserRepository userRepository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findByUsername(username);
      if (user == null) {
         throw new UsernameNotFoundException(username);
      }
      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
   }
}