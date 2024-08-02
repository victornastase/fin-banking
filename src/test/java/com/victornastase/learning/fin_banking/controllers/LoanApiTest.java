package com.victornastase.learning.fin_banking.controllers;

import com.victornastase.learning.fin_banking.models.LoanDTO;
import com.victornastase.learning.fin_banking.services.LoanService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(LoanApi.class)
class LoanApiTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LoanService loanService;

    @Test
    void whenGetAllLoans_thenControlFlowCorrect() throws Exception {
        // Create mock loan objects
        LoanDTO loan1 = new LoanDTO(1L, 12, 1000.0, 0.08);
        LoanDTO loan2 = new LoanDTO(2L, 24, 2000.0, 0.05);

        // Mock the repository's getAllLoans method to return the mock loans
        when(loanService.getLoans()).thenReturn(Arrays.asList(loan1, loan2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/loans/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());

        verify(loanService, Mockito.times(1)).getLoans();
    }
}
