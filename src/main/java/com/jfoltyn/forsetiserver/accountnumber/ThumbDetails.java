package com.jfoltyn.forsetiserver.accountnumber;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ThumbDetails {
   Date timeStamp;
   Thumb thumb;
}
