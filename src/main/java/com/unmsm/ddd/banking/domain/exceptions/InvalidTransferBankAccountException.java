package com.unmsm.ddd.banking.domain.exceptions;

@SuppressWarnings("serial")
public class InvalidTransferBankAccountException extends Exception {
    public InvalidTransferBankAccountException() {
        super("Cannot perform the transfer, invalid data in bank accounts specifications");
    }
}