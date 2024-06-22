package com.victornastase.learning.fin_banking.repositories;

import com.victornastase.learning.fin_banking.entities.Client;
import org.springframework.data.repository.ListCrudRepository;

public interface ClientsRepository extends ListCrudRepository<Client, Integer> {
}
