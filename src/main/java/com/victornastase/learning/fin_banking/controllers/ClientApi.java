package com.victornastase.learning.fin_banking.controllers;

import com.victornastase.learning.fin_banking.entities.Client;
import com.victornastase.learning.fin_banking.repositories.ClientsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@Slf4j
@AllArgsConstructor
public class ClientApi {
    private final ClientsRepository clientsRepository;

    @GetMapping("/all")
    public List<Client> getClients() {
        return clientsRepository.findAll();
    }
}
