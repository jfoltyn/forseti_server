package com.jfoltyn.forsetiserver.controllers;

public interface ServiceDictionary {
   String SIGN_UP = "signup/";

   String API = "api/";

   String ACCOUNT_NUMBER = API + "accountNumber/";
   String ACCOUNT_NUMBER_THUMB = ACCOUNT_NUMBER + "thumb/";
   String ACCOUNT_NUMBER_COMMENT= ACCOUNT_NUMBER + "comment/";

   String USER = API + "user/";
   String USER_COMMENT = USER + "comment/";

   String ADMIN = API + "admin/";
   String ADMIN_USER = ADMIN + "user/";
}
