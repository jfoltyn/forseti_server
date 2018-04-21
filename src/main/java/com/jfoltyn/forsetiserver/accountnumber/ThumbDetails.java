package com.jfoltyn.forsetiserver.accountnumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThumbDetails {
   Date timeStamp;
   Thumb thumb;

   ThumbDetails(Thumb thumb) {
      this.thumb = thumb;
      timeStamp = new Date();
   }
}
