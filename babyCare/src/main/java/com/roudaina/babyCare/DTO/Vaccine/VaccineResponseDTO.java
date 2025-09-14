package com.roudaina.babyCare.DTO.Vaccine;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccineResponseDTO {


    private Long vaccineId;

    private String vaccineName;

    private String description;

    private Integer requiredDoses;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
