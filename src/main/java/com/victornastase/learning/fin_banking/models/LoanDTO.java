package com.victornastase.learning.fin_banking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoanDTO {
    private Long id;
    private int term;
    private double amount;
    private double interestRate;
}
