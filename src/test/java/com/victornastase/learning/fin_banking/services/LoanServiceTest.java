package com.victornastase.learning.fin_banking.services;

import com.victornastase.learning.fin_banking.entities.Client;
import com.victornastase.learning.fin_banking.entities.Loan;
import com.victornastase.learning.fin_banking.models.LoanDTO;
import com.victornastase.learning.fin_banking.repositories.LoansRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {
    @Mock
    private LoansRepository loansRepository;

    private LoanService loanService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        loanService = new LoanService(loansRepository);
    }

    @Test
    void testGetLoans() {
        // Create mock loan objects
        Loan loan1 = new Loan(1L, 12, 1000.0, 0.08, Client.builder().id(1L).firstName("Test").lastName("User").email("test@t.com").build());
        Loan loan2 = new Loan(2L, 24, 2000.0, 0.05, Client.builder().id(1L).firstName("Jon").lastName("Java").email("jon@t.com").build());

        // Mock the repository's getAllLoans method to return the mock loans
        when(loansRepository.getAllLoans()).thenReturn(Arrays.asList(loan1, loan2));

        // Call the getLoans method of the loan service
        List<LoanDTO> loans = loanService.getLoans();

        // Assert that the returned loans are correct
        assertEquals(2, loans.size());
        assertEquals(1L, loans.getFirst().getId());
        assertEquals(12, loans.getFirst().getTerm());
        assertEquals(1000.0, loans.getFirst().getAmount());
        assertEquals(0.08, loans.getFirst().getInterestRate());
        assertEquals(2L, loans.getLast().getId());
        assertEquals(24, loans.getLast().getTerm());
        assertEquals(2000.0, loans.getLast().getAmount());
        assertEquals(0.05, loans.getLast().getInterestRate());
    }
}
