package com.eldorado.kennedy.handsonsegundasemana.service;

import com.eldorado.kennedy.handsonsegundasemana.domain.model.ClientEntity;
import com.eldorado.kennedy.handsonsegundasemana.domain.model.ClientImcEntity;
import com.eldorado.kennedy.handsonsegundasemana.domain.model.ImcEntity;
import com.eldorado.kennedy.handsonsegundasemana.domain.repository.ClientImcRepository;
import com.eldorado.kennedy.handsonsegundasemana.domain.repository.ImcRepository;
import com.eldorado.kennedy.handsonsegundasemana.dto.ClientImcDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientImcService {

    private final ClientImcRepository clientImcRepository;
    private final ImcRepository imcRepository;


    public ClientImcDto saveImc(ClientImcDto clientImcDto) {

        var clientImcEntity = ClientImcEntity.builder()
                .id(UUID.randomUUID())
                .build();

        clientImcEntity.setImcEntity(calculateImc(clientImcDto));

        var clientImcEntitySave = clientImcRepository.save(clientImcEntity);

        log.info("IMC SUCCESSFULLY SAVED  {}", clientImcEntitySave);
        clientImcDto.setId(clientImcEntitySave.getId());

        return clientImcDto;
    }

    public void calcImc(double imc, ClientEntity client){
        String response = "";
        if(imc >= 40) {
            response = "Obesity III (morbid)";
        } else if (imc >= 35) {
            response = "Obesity stage II (severe)";
        } else if (imc >= 30) {
            response = "Obesity stage I";
        } else if (imc >= 25) {
            response = "Slightly above the weight";
        } else if (imc >= 18.6) {
            response = "Ideal weight (congrats)";
        } else {
            response = "Below weight";
        }

        log.info(client.toString());
        log.info(response);
    }

    public void obesityLevel(String imcResult){
        switch (imcResult){
            case "Obesity III (morbid)":
                log.info("III");
                break;
            case "Obesity stage II (severe)":
                log.info("II");
                break;
            case "Obesity stage I":
                log.info("I");
                break;
            default:
                log.info("0");
        }
    }

    public ImcEntity calculateImc(ClientImcDto clientImcDto) {
        var bodyMass = clientImcDto.getWeight() / Math.pow(clientImcDto.getHeight(), 2d);

        var imcs = imcRepository.findAll();
        Collections.sort(imcs);

        return imcs.stream()
                .filter(imcEntity -> imcEntity.getBodyMass() > bodyMass)
                .findFirst()
                .orElse(ImcEntity.builder().classification("NOT DEFINED").build());
    }


}
