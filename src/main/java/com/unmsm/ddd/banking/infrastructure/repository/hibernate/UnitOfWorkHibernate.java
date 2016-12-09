package com.unmsm.ddd.banking.infrastructure.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.unmsm.ddd.banking.domain.repository.abstractions.BankAccountRepository;
import com.unmsm.ddd.banking.domain.repository.abstractions.CustomerRepository;
import com.unmsm.ddd.banking.infrastructure.abstractions.UnitOfWork;

public class UnitOfWorkHibernate implements UnitOfWork {
    private Transaction transaction;
    private SessionFactory sessionFactory;
    private Session session;    
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;

    public UnitOfWorkHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }    

    public void beginTransaction() {
        this.transaction = session.beginTransaction();
    }

    public void commitTransaction() {
        this.transaction.commit();
    }

    public void rollbackTransaction() {
        this.transaction.rollback();
    }
    
    public Session getSession() {
        return this.session;
    }    

    public <T> void save(T entity) {
        this.session.save(entity);
    }
    
    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
    
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public BankAccountRepository getBankAccountRepository() {
        return bankAccountRepository;
    }
    
    public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
}