package com.unmsm.ddd.banking.infrastructure.repository.hibernate;

import org.hibernate.query.Query;

import com.unmsm.ddd.banking.domain.entities.Customer;
import com.unmsm.ddd.banking.domain.repository.abstractions.CustomerRepository;

public class CustomerHibernateRepository implements CustomerRepository {
    private UnitOfWorkHibernate unitOfWork;

    public CustomerHibernateRepository(UnitOfWorkHibernate unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    public Customer get(long customerId) {
        Query<Customer> query =
            this.unitOfWork.getSession().createQuery("FROM Customer c WHERE c.id = :id", Customer.class);
        query.setParameter("id", customerId);
        return query.getSingleResult();
    }
}