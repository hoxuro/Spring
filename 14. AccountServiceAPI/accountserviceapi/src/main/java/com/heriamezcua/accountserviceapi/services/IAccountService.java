package com.heriamezcua.accountserviceapi.services;

import com.heriamezcua.accountserviceapi.model.Account;

import java.util.List;

public interface IAccountService {

    List<Account> getAccounts();

    Account getAccount(Long id);

    List<Account> getAccountsByCustomerId(Long customerId);

    Account createAccount(Account account);

    Account updateAccount(Long accountId, Account account);

    void deleteAccount(Long id);

    Account addBalance(Long accountId, int amount);

    Account withdrawBalance(Long accountId, int amount) throws Exception;

    void deleteCustomerAccounts(Long customerId);

}
