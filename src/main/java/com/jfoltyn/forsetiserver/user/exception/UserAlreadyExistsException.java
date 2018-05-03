package com.jfoltyn.forsetiserver.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "UserAlreadyExistsException")
public class UserAlreadyExistsException extends IllegalStateException {
   public UserAlreadyExistsException(){
      super();
   }
}
