package com.heriamezcua.accountserviceapi.exception;

public class AccountNotFoundException extends RuntimeException {
    protected static final long serialVersionUID = 2L;

    public AccountNotFoundException() {
        super("Account not found");
    }

    public AccountNotFoundException(Long accountId) {
        super("Account with id: " + accountId + " not found");
    }
}
