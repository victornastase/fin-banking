package com.victornastase.learning.fin_banking.controllers;

import com.victornastase.learning.fin_banking.models.LoanDTO;
import com.victornastase.learning.fin_banking.services.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@Slf4j
@RequiredArgsConstructor
public class LoanApi {
    private final LoanService loanService;

    @GetMapping("/all")
    public List<LoanDTO> getLoans() {
        log.info("Getting all loans");
        return loanService.getLoans();
    }
}
