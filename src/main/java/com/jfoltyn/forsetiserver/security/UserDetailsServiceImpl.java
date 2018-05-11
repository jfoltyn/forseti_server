package com.jfoltyn.forsetiserver.security;

import com.jfoltyn.forsetiserver.user.User;
import com.jfoltyn.forsetiserver.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

import static com.jfoltyn.forsetiserver.security.SecurityConstants.*;

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
      GrantedAuthority authority;
      if (user.isAdmin()) {
         authority = new SimpleGrantedAuthority(ROLE + ADMIN);
      } else {
         authority = new SimpleGrantedAuthority(ROLE + USER);
      }
      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singletonList(authority));
   }
}