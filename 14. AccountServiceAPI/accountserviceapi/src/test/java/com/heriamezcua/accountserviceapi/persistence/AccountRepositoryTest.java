package com.heriamezcua.accountserviceapi.persistence;

import com.heriamezcua.accountserviceapi.model.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // annotation to select the order of method execution
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accRepo;

    @Test
    @Order(1)
    void testBean() {
        assertNotNull(accRepo);
    }

    @Test
    @Order(2)
    void givenAccounts_WhenFindByOwnerId_ThenIsGreaterThan0() {
        List<Account> accounts = accRepo.findByOwnerId(1L);
        System.out.println(accounts);
//        assertNotNull(accounts);
        assertTrue(accounts.size() > 0);
    }

    @Test
    @Order(3)
    void givenAccounts_WhenDeleteByOwnerId_ThenNull() {
        accRepo.deleteByOwnerId(1L);
        List<Account> accounts = accRepo.findByOwnerId(1L);
//        System.out.println(accounts);
        assertEquals(accounts.size(), 0);
    }

}
