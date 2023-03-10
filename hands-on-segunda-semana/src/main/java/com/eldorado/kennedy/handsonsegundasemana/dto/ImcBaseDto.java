package com.eldorado.kennedy.handsonsegundasemana.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ImcBaseDto {
    private UUID id;
    private float bodyMass;
    private String classification;
    private String obesityLevel;
    private LocalDateTime createAt;
}
