package com.jfoltyn.forsetiserver.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "NoSuchCommentException")
public class NoSuchCommentException extends IllegalStateException {
   public NoSuchCommentException() {
      super();
   }
}
