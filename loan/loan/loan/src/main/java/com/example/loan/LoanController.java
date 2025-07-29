package com.example.loan;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoanController {

    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        return new Loan(number, "home loan", 540000);
    }

    static class Loan {
        private String number;
        private String type;
        private int loanAmount;

        public Loan(String number, String type, int loanAmount) {
            this.number = number;
            this.type = type;
            this.loanAmount = loanAmount;
        }

        public String getNumber() {
            return number;
        }

        public String getType() {
            return type;
        }

        public int getLoanAmount() {
            return loanAmount;
        }
    }
}
