package com.heriamezcua.accountserviceapi.services;

import com.heriamezcua.accountserviceapi.exception.AccountNotFoundException;
import com.heriamezcua.accountserviceapi.model.Account;
import com.heriamezcua.accountserviceapi.model.Customer;
import com.heriamezcua.accountserviceapi.persistence.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IAccountServiceTest {

    @Autowired
    IAccountService accService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testBean() {
        assertNotNull(accService);
    }

    @Test
    void getAccounts() {
        List<Account> accounts = accService.getAccounts();
        assertNotNull(accounts);
        assertTrue(accounts.size() > 0);
    }

    @Test
    void getAccount() {
        Account account = accService.getAccount(1L);
        assertNotNull(account);
        assertEquals(account.getId(), 1L);
    }

    @Test
    void getAccountsByCustomerId() {
        List<Account> accounts = accService.getAccountsByCustomerId(1L);
        assertNotNull(accounts);
        assertTrue(accounts.size() > 0);
    }

    @Test
    void createAccount() {
        Account newAccount = new Account(null, "Personal", LocalDate.now(), 100, new Customer(null, "Charles", "c@c.com"));
        accService.createAccount(newAccount);
        assertNotNull(newAccount);
        assertTrue(newAccount.getId() > 0);
    }

    @Test
    void updateAccount() {
        Account account = new Account();
        account.setType("Enterprise");
        accService.updateAccount(1L, account);

        Account updatedAccount = accService.getAccount(1L);
        assertNotNull(updatedAccount);
        assertEquals(updatedAccount.getType(), "Enterprise");
    }

    @Test
    void deleteAccount() {
        accService.deleteAccount(1L);
        assertThrows(Exception.class, () -> {
            Account originalAccount = accService.getAccount(1L);
        });
    }

    @Test
    void addBalance() {
        Account originalAccount = accService.getAccount(1L);
        int amount = 10;

        accService.addBalance(1L, amount);
        Account updatedAccount = accService.getAccount(1L);
        assertEquals(updatedAccount.getBalance(), originalAccount.getBalance() + amount);
    }

    @Test
    void withdrawBalanceOK() throws Exception {
        Account originalAccount = accService.getAccount(1L);
        int amount = 10;

        accService.withdrawBalance(1L, amount);

        Account updatedAccount = accService.getAccount(1L);
        assertEquals(updatedAccount.getBalance(), originalAccount.getBalance() - amount);
    }

    @Test
    void withdrawBalanceNOK() {
        Account originalAccount = accService.getAccount(1L);
        int amount = 1000;

        assertThrows(Exception.class, () -> {
            accService.withdrawBalance(1L, amount);
        });
    }
}
