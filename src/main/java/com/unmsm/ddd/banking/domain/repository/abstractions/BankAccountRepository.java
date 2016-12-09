package com.unmsm.ddd.banking.domain.repository.abstractions;

import com.unmsm.ddd.banking.domain.entities.BankAccount;

public interface BankAccountRepository {
    BankAccount findByNumber(String accountNumber) throws Exception;
}