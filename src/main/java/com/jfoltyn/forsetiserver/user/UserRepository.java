package com.jfoltyn.forsetiserver.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

   User findByUsername(String username);
   List<User> findAllByIsRemovedFalse();
   List<User> findAllByIsRemovedTrue();
}
