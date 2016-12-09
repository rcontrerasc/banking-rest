package com.unmsm.ddd.banking.domain.entities;

import java.math.BigDecimal;

import com.unmsm.ddd.banking.domain.exceptions.*;

public class BankAccount {
    private long id;
    private String number;
    private BigDecimal balance;
    private boolean isLocked;
    private Customer customer;

    public BankAccount() {
    }

    public void lock() {
        if (!this.isLocked) {
            this.isLocked = true;
        }
    }

    public void unLock() {
        if (this.isLocked) {
            this.isLocked = false;
        }
    }

    public boolean hasIdentity() {
        return !this.number.trim().equals("");
    }

    public void withdrawMoney(BigDecimal amount) throws CannotWithdrawException, Exception {
        this.validateAmount(amount);
        if (!this.canBeWithdrawed(amount)) {
            throw new CannotWithdrawException();
        }
        this.balance = this.balance.subtract(amount);
    }

    public void depositMoney(BigDecimal amount) throws CannotDepositException, Exception {
        this.validateAmount(amount);
        if (this.isLocked) {
            throw new CannotDepositException();
        }
        this.balance = this.balance.add(amount);
    }

    private void validateAmount(BigDecimal amount) throws AmountLessOrEqualToZeroException {
        if (amount.signum() <= 0) {
            throw new AmountLessOrEqualToZeroException();
        }
    }

    public boolean canBeWithdrawed(BigDecimal amount) {
        return !this.isLocked && (this.balance.compareTo(amount) >= 0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}