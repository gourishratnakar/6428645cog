package com.example.account;

import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        return new Account(number, "savings", 234343);
    }

    static class Account {
        private String number;
        private String type;
        private int balance;

        public Account(String number, String type, int balance) {
            this.number = number;
            this.type = type;
            this.balance = balance;
        }

        public String getNumber() {
            return number;
        }

        public String getType() {
            return type;
        }

        public int getBalance() {
            return balance;
        }
    }
}
