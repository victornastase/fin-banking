package com.victornastase.learning.fin_banking.services;

import com.victornastase.learning.fin_banking.models.LoanDTO;
import com.victornastase.learning.fin_banking.repositories.LoansRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoanService {
    private final LoansRepository loansRepository;

    public List<LoanDTO> getLoans() {
        log.info("Getting all loans");
        return loansRepository.getAllLoans()
                .stream()
                .map(loan -> new LoanDTO(loan.getId(), loan.getTerm(),
                        loan.getAmount(), loan.getInterestRate()))
                .toList();
    }
}
