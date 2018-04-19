package com.jfoltyn.forsetiserver.accountnumber;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

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

   List<ThumbDetails> thumbsUpDetails = new ArrayList<>();
   List<ThumbDetails> thumbsDownDetails = new ArrayList<>();

   List<Comment> comments = new ArrayList<>();

   AccountNumber(String number) {
      this.accountNumber = number;
   }

   void addThumb(ThumbDetails thumbDetails) {
      if (thumbDetails.thumb == Thumb.UP) {
         thumbsUp++;
         thumbsUpDetails.add(thumbDetails);
      } else {
         thumbsDown++;
         thumbsDownDetails.add(thumbDetails);
      }
   }
}
