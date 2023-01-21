package com.eldorado.kennedy.handsonsegundasemana.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("client")
public class ClientEntity {
    private UUID id;
    private String name;
    private char gender;
    private String documentId;
    private LocalDate birthDate;
    private int frequencyDaysInMonth;
    private String phoneNumber;
    private String address;
    private LocalDateTime offsetDateTime;
    private String createdBy;

}
