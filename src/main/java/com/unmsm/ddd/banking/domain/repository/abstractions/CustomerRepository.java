package com.unmsm.ddd.banking.domain.repository.abstractions;

import com.unmsm.ddd.banking.domain.entities.Customer;

public interface CustomerRepository {
    public Customer get(long customerId);
}