package com.eldorado.kennedy.handsonsegundasemana.controller;

import com.eldorado.kennedy.handsonsegundasemana.dto.ImcBaseDto;
import com.eldorado.kennedy.handsonsegundasemana.service.ImcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/imc-calculator")
@Slf4j
@RequiredArgsConstructor
public class ImcController {

    private final ImcService imcService;

    @PostMapping
    public ResponseEntity<ImcBaseDto> saveImc(@RequestBody ImcBaseDto imcBaseDto) {
        log.info("IMC Base {} ", imcBaseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(imcService.saveImc(imcBaseDto));
    }


}
