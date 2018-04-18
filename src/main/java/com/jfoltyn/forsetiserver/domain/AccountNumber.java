package com.jfoltyn.forsetiserver.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountNumber {
   String accountNumber;

   int thumbsUp;
   int thumbsDown;
}
