package com.code_compilers.CC_BANK.service;

import com.code_compilers.CC_BANK.exception.UserNotFoundException;
import com.code_compilers.CC_BANK.model.User;
import com.code_compilers.CC_BANK.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserFromPrincipal(Principal principal) {
        // Use the injected userRepository to fetch the user by username
        return UserRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
