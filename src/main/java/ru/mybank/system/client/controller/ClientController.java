package ru.mybank.system.client.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mybank.system.client.entity.Client;
import ru.mybank.system.client.entity.dto.ClientRequestDto;
import ru.mybank.system.client.entity.dto.ClientResponseDto;
import ru.mybank.system.client.service.ClientService;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/{id}")
    public ClientResponseDto getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @PostMapping
    public ClientResponseDto saveClient(@Valid @RequestBody ClientRequestDto clientRequestDto){
        return clientService.saveClient(clientRequestDto);
    }

}
