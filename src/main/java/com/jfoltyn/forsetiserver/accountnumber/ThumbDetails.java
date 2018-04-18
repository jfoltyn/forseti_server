package com.jfoltyn.forsetiserver.accountnumber;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThumbDetails {
   String userId;
   Thumb thumb;
}
