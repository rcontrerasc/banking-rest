package com.unmsm.ddd.banking.infrastructure.abstractions;

import com.unmsm.ddd.banking.domain.repository.abstractions.BankAccountRepository;
import com.unmsm.ddd.banking.domain.repository.abstractions.CustomerRepository;

public interface UnitOfWork {
    public void beginTransaction();

    public void commitTransaction();

    public void rollbackTransaction();

    public CustomerRepository getCustomerRepository();

    public BankAccountRepository getBankAccountRepository();

    public <T> void save(T entity);
}