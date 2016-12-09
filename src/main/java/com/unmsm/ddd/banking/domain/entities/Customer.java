package com.unmsm.ddd.banking.domain.entities;

import java.util.Set;

public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private boolean isEnabled;
    private Set<BankAccount> bankAccounts;

    public Customer() {
    }

    public void disable() {
        if (this.isEnabled) {
            this.isEnabled = false;
        }
    }

    public void enable() {
        if (!this.isEnabled) {
            this.isEnabled = true;
        }
    }

    public String getFullName() {
        return String.format("%s, %s", this.lastName, this.firstName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}