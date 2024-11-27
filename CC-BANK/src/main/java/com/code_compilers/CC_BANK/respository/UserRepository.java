package com.code_compilers.CC_BANK.respository;

import com.code_compilers.CC_BANK.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);  // This method retrieves a user by their username
    }


