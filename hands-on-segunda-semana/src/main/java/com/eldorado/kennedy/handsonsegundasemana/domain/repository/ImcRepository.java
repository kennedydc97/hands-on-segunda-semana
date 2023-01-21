package com.eldorado.kennedy.handsonsegundasemana.domain.repository;

import com.eldorado.kennedy.handsonsegundasemana.domain.model.ImcEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ImcRepository extends MongoRepository<ImcEntity, UUID> {
}
