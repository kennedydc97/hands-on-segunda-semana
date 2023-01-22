package com.eldorado.kennedy.handsonsegundasemana.controller;

import com.eldorado.kennedy.handsonsegundasemana.dto.ClientDto;
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
    public ResponseEntity<?> getClientImc(@PathVariable UUID clientId) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(clientService.getClientImc(clientId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
