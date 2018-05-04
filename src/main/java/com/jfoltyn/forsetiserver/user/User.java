package com.jfoltyn.forsetiserver.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jfoltyn.forsetiserver.accountnumber.Comment;
import com.jfoltyn.forsetiserver.accountnumber.ThumbDetails;
import io.swagger.annotations.ApiModelProperty;
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
public class User {

   @Id
   @JsonIgnore
   String id;

   String username;
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   String password;

   String firstName;
   String lastName;
   String email;


   @ApiModelProperty(notes = "Map with accountNumber to thumbDetails mapping")
   Map<String, ThumbDetails> thumbsDetails = new HashMap<>();
   @ApiModelProperty(notes = "Map with accountNumber to list of comments mapping")
   Map<String, List<Comment>> comments = new HashMap<>();

   public void addThumb(String accountNumber, ThumbDetails thumbDetails) {
      thumbsDetails.put(accountNumber, thumbDetails);
   }

   public void addComment(String accountNumber, Comment comment) {
      if (!comments.containsKey(accountNumber)) {
         comments.put(accountNumber, new ArrayList<>());
      }
      comments.get(accountNumber).add(comment);
   }
}
