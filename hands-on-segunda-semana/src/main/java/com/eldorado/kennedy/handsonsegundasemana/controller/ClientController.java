package com.eldorado.kennedy.handsonsegundasemana.controller;

import com.eldorado.kennedy.handsonsegundasemana.dto.ClientDto;
import com.eldorado.kennedy.handsonsegundasemana.dto.ClientImcDto;
import com.eldorado.kennedy.handsonsegundasemana.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client")
@Slf4j
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto) {
        log.info("Client registered {} ", clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientDto));
    }

    @GetMapping
    public ResponseEntity<ClientImcDto> getClientImc(@PathVariable UUID clientId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(clientService.getClientImc(clientId));
    }

    @PutMapping("/{clientId}")
    public void updateClient(@PathVariable UUID imcId) {
        log.warn("PUT IMC Not IMPLEMENTED {}", imcId);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable UUID imcId) {
        log.warn("DELETE IMC Not IMPLEMENTED {}", imcId);
    }

    @GetMapping("/{clientId}")
    public void getImc(@PathVariable UUID imcId) {
        log.warn("GET IMC BY ID Not IMPLEMENTED {}", imcId);
    }

}
