package com.unmsm.ddd.banking.infrastructure.repository.hibernate;

import org.hibernate.LockOptions;
import org.hibernate.query.Query;

import com.unmsm.ddd.banking.domain.entities.BankAccount;
import com.unmsm.ddd.banking.domain.repository.abstractions.BankAccountRepository;

public class BankAccountHibernateRepository implements BankAccountRepository {
    private UnitOfWorkHibernate unitOfWork;

    public BankAccountHibernateRepository(UnitOfWorkHibernate unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    public BankAccount findByNumber(String accountNumber) throws Exception {
        Query<BankAccount> query =
            this.unitOfWork.getSession().createQuery("FROM BankAccount b WHERE b.number = :number", BankAccount.class);
        query.setParameter("number", accountNumber);
        query.setLockOptions(LockOptions.UPGRADE);
        return query.getSingleResult();
    }
}