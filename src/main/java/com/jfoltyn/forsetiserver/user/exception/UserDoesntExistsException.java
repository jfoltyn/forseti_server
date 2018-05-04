package com.jfoltyn.forsetiserver.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "UserDoesntExistsException")
public class UserDoesntExistsException extends IllegalStateException {
   public UserDoesntExistsException() {
      super();
   }
}
