package com.victornastase.learning.fin_banking.services;

import com.victornastase.learning.fin_banking.entities.Loan;
import com.victornastase.learning.fin_banking.models.ClientDTO;
import com.victornastase.learning.fin_banking.models.LoanDTO;
import com.victornastase.learning.fin_banking.repositories.ClientsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {
    private final ClientsRepository clientsRepository;

    public List<ClientDTO> getClients() {
        log.info("Getting all clients");
        return clientsRepository.getAllClients().stream()
                .map(c -> new ClientDTO(c.getId(), c.getFirstName(),
                        c.getLastName(), c.getEmail(),
                        createLoanDTOs(c.getLoans())))
                .toList();
    }

    private List<LoanDTO> createLoanDTOs(List<Loan> loans) {
        return loans.stream()
                .map(loan -> new LoanDTO(loan.getId(), loan.getTerm(),
                    loan.getAmount(), loan.getInterestRate()))
                .toList();
    }

}
