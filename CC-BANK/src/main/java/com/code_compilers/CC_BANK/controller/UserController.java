package com.code_compilers.CC_BANK.controller;

import com.code_compilers.CC_BANK.model.User;
import com.code_compilers.CC_BANK.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
;
@RestController
@RequestMapping("/api/accounts")
public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping("/current-user")
        public ResponseEntity<User> getCurrentUser(Principal principal) {
            User user = userService.getUserFromPrincipal(principal);
            return ResponseEntity.ok(user);
        }
    }


