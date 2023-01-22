package com.eldorado.kennedy.handsonsegundasemana.controller;

import com.eldorado.kennedy.handsonsegundasemana.dto.ClientImcDto;
import com.eldorado.kennedy.handsonsegundasemana.service.ClientImcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client-imc")
@Slf4j
@RequiredArgsConstructor
public class ClientImcController {

    private final ClientImcService clientImcService;

    @PostMapping
    public ResponseEntity<ClientImcDto> saveClientImc(@RequestBody ClientImcDto clientImcDto) {
        log.info("Client IMC {} ", clientImcDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientImcService.saveImc(clientImcDto));
    }


}
