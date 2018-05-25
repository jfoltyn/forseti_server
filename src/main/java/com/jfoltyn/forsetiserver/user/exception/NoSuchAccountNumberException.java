package com.jfoltyn.forsetiserver.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "NoSuchAccountNumberException")
public class NoSuchAccountNumberException extends IllegalStateException {
  public NoSuchAccountNumberException() {
    super();
  }
}

