package com.jfoltyn.forsetiserver.accountnumber;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountNumber {

   @Id
   @JsonIgnore
   String id;

   String accountNumber;

   int thumbsUp = 0;
   int thumbsDown = 0;

   Map<String, ThumbDetails> thumbsDetails = new HashMap<>();

   Map<String, List<Comment>> comments = new HashMap<>();

   AccountNumber(String number) {
      this.accountNumber = number;
   }

   void addThumb(String userId, Thumb thumb) {
      ThumbDetails previous = thumbsDetails.get(userId);
      if (previous != null) {
         switch (previous.thumb) {
            case UP:
               thumbsUp--;
               break;
            case DOWN:
               thumbsDown--;
               break;
         }
      }

      if (thumb == Thumb.UP) {
         thumbsUp++;
      } else {
         thumbsDown++;
      }
      thumbsDetails.put(userId, new ThumbDetails(thumb));
   }
}
