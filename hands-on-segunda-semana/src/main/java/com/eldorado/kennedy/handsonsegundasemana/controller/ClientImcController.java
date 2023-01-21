package com.eldorado.kennedy.handsonsegundasemana.controller;

import com.eldorado.kennedy.handsonsegundasemana.dto.ClientImcDto;
import com.eldorado.kennedy.handsonsegundasemana.service.ClientImcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/imc-calculator")
@Slf4j
@RequiredArgsConstructor
public class ClientImcController {

    private final ClientImcService clientImcService;

    @PostMapping
    public ResponseEntity<ClientImcDto> saveImc(@RequestBody ClientImcDto clientImcDto) {
        log.info("IMC Base {} ", clientImcDto);
        return ResponseEntity.ok(clientImcService.saveImc(clientImcDto));
    }

    @GetMapping
    public void getImcList() {
        log.warn("GET IMC Not IMPLEMENTED");
    }

    @PutMapping("/{imcId}")
    public void updateImc(@PathVariable UUID imcId) {
        log.warn("PUT IMC Not IMPLEMENTED {}", imcId);
    }

    @DeleteMapping("/{imcId}")
    public void deleteImc(@PathVariable UUID imcId) {
        log.warn("DELETE IMC Not IMPLEMENTED {}", imcId);
    }

    @GetMapping("/{imcId}")
    public void getImc(@PathVariable UUID imcId) {
        log.warn("GET IMC BY ID Not IMPLEMENTED {}", imcId);
    }


}
