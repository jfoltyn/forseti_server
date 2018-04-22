package com.jfoltyn.forsetiserver.user;

import com.jfoltyn.forsetiserver.accountnumber.Comment;
import com.jfoltyn.forsetiserver.accountnumber.ThumbDetails;
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
public class User {

   @Id
   String id;

   String firstName;
   String lastName;
   String email;


   List<ThumbDetails> thumbsDetails = new ArrayList<>();
   List<Comment> comments = new ArrayList<>();

   public void addThumb(ThumbDetails thumbDetails) {
      thumbsDetails.add(thumbDetails);
   }

   public void addComment(Comment comment) {
      comments.add(comment);
   }
}
