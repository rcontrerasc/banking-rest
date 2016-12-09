package com.unmsm.ddd.banking.domain.exceptions;

@SuppressWarnings("serial")
public class CannotWithdrawException extends Exception {
    public CannotWithdrawException() {
        super("Cannot withdraw in the account, it is locked or amount is greater than balance");
    }
}