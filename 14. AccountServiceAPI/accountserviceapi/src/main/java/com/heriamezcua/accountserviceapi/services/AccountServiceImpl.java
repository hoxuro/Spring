package com.heriamezcua.accountserviceapi.services;

import com.heriamezcua.accountserviceapi.exception.AccountNotFoundException;
import com.heriamezcua.accountserviceapi.model.Account;
import com.heriamezcua.accountserviceapi.model.Customer;
import com.heriamezcua.accountserviceapi.persistence.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public List<Account> getAccountsByCustomerId(Long customerId) {
        return accountRepo.findByOwnerId(customerId);
    }

    @Override
    @Transactional
    public Account createAccount(Account account) {
        LocalDate currentDate = LocalDate.now();
        account.setOpeningDate(currentDate);
        return accountRepo.save(account);
    }

    @Override
    @Transactional
    public Account updateAccount(Long accountId, Account account) {
        Account newAccount = accountRepo.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        newAccount.setType(account.getType());
        return accountRepo.save(newAccount);
    }

    @Override
    @Transactional
    public void deleteAccount(Long id) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
        accountRepo.delete(account);
    }

    @Override
    @Transactional
    public Account addBalance(Long accountId, int amount) {
        Account newAccount = accountRepo.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        Customer owner = null;// Will be gotten from user service
        int newBalance = newAccount.getBalance() + amount;
        newAccount.setBalance(newBalance);
        return accountRepo.save(newAccount);
    }

    @Override
    @Transactional
    public Account withdrawBalance(Long accountId, int amount) throws Exception {
        Account newAccount = accountRepo.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        Customer owner = null; // Will be gotten from user service
        int newBalance = newAccount.getBalance() - amount;
        if (newBalance > 0) {
            newAccount.setBalance(newBalance);
            return accountRepo.save(newAccount);
        } else {
            throw new Exception("You do not have enough balance");
        }
    }

    @Override
    @Transactional
    public void deleteCustomerAccounts(Long customerId) {
        accountRepo.deleteByOwnerId(customerId);
    }
}
