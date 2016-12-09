package com.unmsm.ddd.banking.domain.exceptions;

@SuppressWarnings("serial")
public class CannotDepositException extends Exception {
    public CannotDepositException() {
        super("Cannot deposit in the account, it is locked");
    }
}