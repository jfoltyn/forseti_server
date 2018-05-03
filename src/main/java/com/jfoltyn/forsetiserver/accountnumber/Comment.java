package com.jfoltyn.forsetiserver.accountnumber;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Comment {
   static AtomicLong idCounter = new AtomicLong();

   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   long id;
   Date timeStamp;
   String comment;

   public Comment(String comment) {
      this.comment = comment;

      timeStamp = new Date();
      id = idCounter.incrementAndGet();
   }

   public Comment(String comment, Date timeStamp) {
      this.comment = comment;
      this.timeStamp = timeStamp;

      id = idCounter.incrementAndGet();
   }
}
