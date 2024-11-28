package com.code_compilers.CC_BANK.repository;

import com.code_compilers.CC_BANK.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
