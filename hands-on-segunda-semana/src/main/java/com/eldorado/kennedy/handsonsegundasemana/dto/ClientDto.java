package com.eldorado.kennedy.handsonsegundasemana.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
    private UUID id;
    private String name;
    private char gender;
    private String documentId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    private int frequencyDaysInMonth;
    private String phoneNumber;
    private String address;
    private String createdAt;
    private CustomImcList clientImcs;
    private boolean hasChanged;
}
