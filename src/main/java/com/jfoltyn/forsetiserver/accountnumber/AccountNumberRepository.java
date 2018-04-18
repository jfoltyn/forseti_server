package com.jfoltyn.forsetiserver.accountnumber;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountNumberRepository extends MongoRepository<AccountNumber, String> {

   AccountNumber findAccountNumberByAccountNumber(String number);

}
