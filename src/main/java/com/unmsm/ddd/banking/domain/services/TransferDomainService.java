package com.unmsm.ddd.banking.domain.services;

import java.math.BigDecimal;

import com.unmsm.ddd.banking.domain.entities.BankAccount;
import com.unmsm.ddd.banking.domain.exceptions.*;

public class TransferDomainService {

    public TransferDomainService() {
    }

    public void performTransfer(BankAccount originAccount, BankAccount destinationAccount, BigDecimal amount)
        throws Exception {
        this.validateData(originAccount, destinationAccount, amount);
        originAccount.withdrawMoney(amount);
        destinationAccount.depositMoney(amount);
    }

    private void validateData(BankAccount originAccount, BankAccount destinationAccount, BigDecimal amount)
        throws InvalidTransferBankAccountException, SameTransferBankAccountException {
        if (originAccount == null && destinationAccount == null) {
            throw new InvalidTransferBankAccountException();
        }
        if (originAccount.getNumber().equals(destinationAccount.getNumber())) {
            throw new SameTransferBankAccountException();
        }
    }
}