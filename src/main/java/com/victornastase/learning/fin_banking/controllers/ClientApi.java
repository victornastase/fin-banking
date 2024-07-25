package com.victornastase.learning.fin_banking.controllers;

import com.victornastase.learning.fin_banking.entities.Client;
import com.victornastase.learning.fin_banking.models.ClientDTO;
import com.victornastase.learning.fin_banking.repositories.ClientsRepository;
import com.victornastase.learning.fin_banking.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@Slf4j
@RequiredArgsConstructor
public class ClientApi {
    private final ClientService clientService;

    @GetMapping("/all")
    public List<ClientDTO> getClients() {
        log.info("Getting all clients");
        return clientService.getClients();
    }

    @GetMapping("client/{email}")
    public ClientDTO getClient(@PathVariable String email) {
        log.info("Getting client by email. Email: {}", email);
        return clientService.getClient(email);
    }
}
