package com.heriamezcua.accountserviceapi.persistence;

import com.heriamezcua.accountserviceapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByOwnerId(Long OwnerId);

    @Transactional
    void deleteByOwnerId(Long OwnerId);
}
