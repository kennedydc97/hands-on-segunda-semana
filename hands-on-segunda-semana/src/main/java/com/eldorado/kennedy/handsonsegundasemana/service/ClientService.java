package com.eldorado.kennedy.handsonsegundasemana.service;

import com.eldorado.kennedy.handsonsegundasemana.domain.model.ClientEntity;
import com.eldorado.kennedy.handsonsegundasemana.domain.model.ClientImcEntity;
import com.eldorado.kennedy.handsonsegundasemana.domain.repository.ClientImcRepository;
import com.eldorado.kennedy.handsonsegundasemana.domain.repository.ClientRepository;
import com.eldorado.kennedy.handsonsegundasemana.dto.ClientDto;
import com.eldorado.kennedy.handsonsegundasemana.dto.ClientImcDto;
import com.eldorado.kennedy.handsonsegundasemana.dto.CustomImcList;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientImcRepository clientImcRepository;
    private final ModelMapper modelMapper;

    public ClientDto saveClient(ClientDto clientDto) {

        var clientEntity = modelMapper.map(clientDto, ClientEntity.class);
        clientEntity.setId(UUID.randomUUID());
        clientEntity.setOffsetDateTime(LocalDateTime.now());
        clientEntity.setCreatedBy("Kennedy Dourado");


        var clientEntitySave = clientRepository.save(clientEntity);

        log.info("CLIENT SUCCESSFULLY SAVED  {}", clientEntitySave);
        clientDto.setId(clientEntitySave.getId());

        return clientDto;
    }

    @SneakyThrows
    public ClientImcDto getClientImc(UUID id) {
        var client = clientRepository.findById(id).
                orElseThrow(() -> new Exception("NOT FOUND"));

        var clientImcs = clientImcRepository.findAllByClientId(id);

        var clientCustom = Arrays.asList(modelMapper.map(clientImcs, ClientImcDto[].class));

        var clientDto = modelMapper.map(client, ClientDto.class);
        clientDto.setClientImcs(clientCustom);
        clientDto.setHasChanged(verifyChangeImc(clientImcs));

        verifyChangeImc(clientImcs);

        return null;
    }

    private boolean verifyChangeImc(List<ClientImcEntity> clientImcs) {

        return !clientImcs.
                stream()
                .collect(groupingBy(client ->
                        client.getImcEntity()
                                .getClassification())).isEmpty();

    }

}
