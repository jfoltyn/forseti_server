package com.jfoltyn.forsetiserver.accountnumber;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
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

   public void addThumb(String username, ThumbDetails thumbDetails) {
      ThumbDetails previous = thumbsDetails.get(username);
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

      if (thumbDetails.getThumb() == Thumb.UP) {
         thumbsUp++;
      } else {
         thumbsDown++;
      }
      thumbsDetails.put(username, thumbDetails);
   }

   public void addComment(String username, Comment comment) {
      if (!comments.containsKey(username)) {
         comments.put(username, new ArrayList<>());
      }

      comments.get(username).add(comment);
   }
}
