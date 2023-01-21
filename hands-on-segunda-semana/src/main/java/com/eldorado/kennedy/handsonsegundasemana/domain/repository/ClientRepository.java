package com.eldorado.kennedy.handsonsegundasemana.domain.repository;

import com.eldorado.kennedy.handsonsegundasemana.domain.model.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ClientRepository extends MongoRepository<ClientEntity, UUID> {
}
