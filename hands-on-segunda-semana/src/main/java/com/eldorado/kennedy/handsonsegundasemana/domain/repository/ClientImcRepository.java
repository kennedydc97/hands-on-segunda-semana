package com.eldorado.kennedy.handsonsegundasemana.domain.repository;

import com.eldorado.kennedy.handsonsegundasemana.domain.model.ClientImcEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ClientImcRepository extends MongoRepository<ClientImcEntity, UUID> {
    List<ClientImcEntity> findAllByClientId(UUID id);
}
