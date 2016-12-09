package com.unmsm.ddd.banking.application.assemblers;

import com.unmsm.ddd.banking.application.dtos.BankAccountDto;
import com.unmsm.ddd.banking.domain.entities.BankAccount;

public class BankAccountAssembler {
    private CustomerAssembler customerAssembler;

    public void setCustomerAssembler(CustomerAssembler customerAssembler) {
        this.customerAssembler = customerAssembler;
    }

    public BankAccountDto toDto(BankAccount bankAccount) {
        if (bankAccount == null) {
            return null;
        }
        BankAccountDto bankAccountDto = new BankAccountDto();
        bankAccountDto.setId(bankAccount.getId());
        bankAccountDto.setNumber(bankAccount.getNumber());
        bankAccountDto.setBalance(bankAccount.getBalance());
        bankAccountDto.setIsLocked(bankAccount.getIsLocked());
        bankAccountDto.setCustomerDto(this.customerAssembler.toDto(bankAccount.getCustomer()));
        return bankAccountDto;
    }

    public BankAccount toEntity(BankAccountDto bankAccountDto) {
        if (bankAccountDto == null) {
            return null;
        }
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(bankAccount.getId());
        bankAccount.setNumber(bankAccount.getNumber());
        bankAccount.setBalance(bankAccount.getBalance());
        bankAccount.setIsLocked(bankAccount.getIsLocked());
        bankAccount.setCustomer(this.customerAssembler.toEntity(bankAccountDto.getCustomerDto()));
        return bankAccount;
    }
}