package com.eldorado.kennedy.handsonsegundasemana.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientImcDto {
    @Id
    private UUID id;
    private UUID clientId;
    private float weight;
    private double height;
    private String classification;
    private String obesityLevel;
}
