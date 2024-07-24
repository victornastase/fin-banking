package com.victornastase.learning.fin_banking.repositories;

import com.victornastase.learning.fin_banking.entities.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface LoansRepository extends ListCrudRepository<Loan, Long> {
    @Query("select l from Loan l join fetch l.client")
    List<Loan> getAllLoans(); // <1>
}
