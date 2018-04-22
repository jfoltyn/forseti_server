package com.jfoltyn.forsetiserver.generator;

import com.jfoltyn.forsetiserver.accountnumber.Comment;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import static com.jfoltyn.forsetiserver.generator.ConstantsRepository.loremIpsum;
import static java.lang.Math.random;

@Component
public class CommentGenerator {
   public Comment generate(Date oldestActivityDate) {
      return new Comment(getRandomDateSince(oldestActivityDate), getRandomLengthLorem());
   }

   private Date getRandomDateSince(Date dateSince) {
      return new Date(ThreadLocalRandom.current().nextLong(dateSince.getTime(), System.currentTimeMillis()));
   }

   private String getRandomLengthLorem() {
      String lorem = loremIpsum().substring(0, 10 + ((int) (random() * (loremIpsum().length() - 10))));
      if (lorem.charAt(lorem.length() - 1) != '.') {
         lorem += ".";
      }
      return lorem;
   }
}
