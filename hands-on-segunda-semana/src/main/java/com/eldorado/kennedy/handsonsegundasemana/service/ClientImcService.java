package com.eldorado.kennedy.handsonsegundasemana.service;

import com.eldorado.kennedy.handsonsegundasemana.domain.model.ClientEntity;
import com.eldorado.kennedy.handsonsegundasemana.domain.model.ClientImcEntity;
import com.eldorado.kennedy.handsonsegundasemana.domain.model.ImcEntity;
import com.eldorado.kennedy.handsonsegundasemana.domain.repository.ClientImcRepository;
import com.eldorado.kennedy.handsonsegundasemana.domain.repository.ImcRepository;
import com.eldorado.kennedy.handsonsegundasemana.dto.ClientImcDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientImcService {

    private final ClientImcRepository clientImcRepository;
    private final ImcRepository imcRepository;
    private final ModelMapper modelMapper;


    public ClientImcDto saveImc(ClientImcDto clientImcDto) {

        clientImcDto.setId(UUID.randomUUID());
        var clientImcEntity = modelMapper.map(clientImcDto, ClientImcEntity.class);
        var bodyMass = calculateBodyMass(clientImcDto);

        clientImcEntity.setImcEntity(calculateImc(bodyMass));

        clientImcEntity.setBodyMass(bodyMass);

        var clientImcEntitySave = clientImcRepository.save(clientImcEntity);

        log.info("IMC SUCCESSFULLY SAVED  {}", clientImcEntitySave);
        clientImcDto.setId(clientImcEntitySave.getId());

        return clientImcDto;
    }

    public ImcEntity calculateImc(Double bodyMass) {

        var imcs = imcRepository.findAll();
        Collections.sort(imcs);

        return imcs.stream()
                .filter(imcEntity -> imcEntity.getBodyMass() > bodyMass)
                .findFirst()
                .orElse(ImcEntity.builder().classification("NOT DEFINED").build());
    }

    private Double calculateBodyMass(ClientImcDto clientImcDto) {
        return clientImcDto.getWeight() / (clientImcDto.getHeight() * clientImcDto.getHeight());
    }

}
