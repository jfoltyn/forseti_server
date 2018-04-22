package com.jfoltyn.forsetiserver.accountnumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
   Date timeStamp;
   String comment;
}
