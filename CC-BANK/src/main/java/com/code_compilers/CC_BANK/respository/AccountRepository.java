package com.code_compilers.CC_BANK.respository;

import com.code_compilers.CC_BANK.model.Account;
import com.code_compilers.CC_BANK.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserAndAccountType(User user, String accountType);
}
