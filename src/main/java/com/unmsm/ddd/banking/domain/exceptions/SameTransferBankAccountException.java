package com.unmsm.ddd.banking.domain.exceptions;

@SuppressWarnings("serial")
public class SameTransferBankAccountException extends Exception {
    public SameTransferBankAccountException() {
        super("Cannot transfer money to the same bank account");
    }
}