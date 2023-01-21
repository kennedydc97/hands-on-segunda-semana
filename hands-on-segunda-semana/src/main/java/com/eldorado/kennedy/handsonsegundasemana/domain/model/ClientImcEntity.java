package com.eldorado.kennedy.handsonsegundasemana.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("client-imc")
public class ClientImcEntity {

    @Id
    private UUID id;

    private UUID clientId;
    private double height;
    private double weight;

    private ImcEntity imcEntity;
}
