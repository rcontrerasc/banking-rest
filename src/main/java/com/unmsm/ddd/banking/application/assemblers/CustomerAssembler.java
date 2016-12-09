package com.unmsm.ddd.banking.application.assemblers;

import java.util.HashSet;
import java.util.Set;

import com.unmsm.ddd.banking.application.dtos.BankAccountDto;
import com.unmsm.ddd.banking.application.dtos.CustomerDto;
import com.unmsm.ddd.banking.domain.entities.BankAccount;
import com.unmsm.ddd.banking.domain.entities.Customer;

public class CustomerAssembler {
    private BankAccountAssembler bankAccountAssembler;

    public void setBankAccountAssembler(BankAccountAssembler bankAccountAssembler) {
        this.bankAccountAssembler = bankAccountAssembler;
    }

    public CustomerDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setIsEnabled(customer.getIsEnabled());
        customerDto.setBankAccountsDto(this.toListDto(customer.getBankAccounts()));
        return customerDto;
    }

    public Set<BankAccountDto> toListDto(Set<BankAccount> bankAccounts) {
        if (bankAccounts == null) {
            return null;
        }
        Set<BankAccountDto> bankAccountsDto = new HashSet<BankAccountDto>();
        for (BankAccount bankAccount : bankAccounts) {
            bankAccountsDto.add(this.bankAccountAssembler.toDto(bankAccount));
        }
        return bankAccountsDto;
    }

    public Customer toEntity(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setIsEnabled(customerDto.getIsEnabled());
        customer.setBankAccounts(this.toListEntity(customerDto.getBankAccountsDto()));
        return customer;
    }

    public Set<BankAccount> toListEntity(Set<BankAccountDto> bankAccountsDto) {
        if (bankAccountsDto == null) {
            return null;
        }
        Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
        for (BankAccountDto bankAccountDto : bankAccountsDto) {
            bankAccounts.add(this.bankAccountAssembler.toEntity(bankAccountDto));
        }
        return bankAccounts;
    }
}