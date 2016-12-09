package com.unmsm.ddd.banking.application.dtos;

import java.util.Set;

public class CustomerDto {
    private long id;
    private String firstName;
    private String lastName;
    private boolean isEnabled;
    private Set<BankAccountDto> bankAccountsDto;

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

    public Set<BankAccountDto> getBankAccountsDto() {
        return bankAccountsDto;
    }

    public void setBankAccountsDto(Set<BankAccountDto> bankAccountsDto) {
        this.bankAccountsDto = bankAccountsDto;
    }
}