package com.victornastase.learning.fin_banking.repositories;

import com.victornastase.learning.fin_banking.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ClientsRepository extends ListCrudRepository<Client, Long> {
    @Query("select c from Client c join fetch c.loans")
    List<Client> getAllClients();
    @Query("select c from Client c where c.email = :email")
    Client findByEmail(String email);
}
