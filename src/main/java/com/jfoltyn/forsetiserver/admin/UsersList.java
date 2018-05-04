package com.jfoltyn.forsetiserver.admin;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsersList {
   private List<String> users = new ArrayList<>();
   private List<String> removedUsers = new ArrayList<>();
}
