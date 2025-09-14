package com.roudaina.babyCare.HeathRecordDTO;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthRecordResponseDTO {


    private Long recordId;
    private LocalDate measurementDate;
    private BigDecimal temperature;
    private Integer heartRate;
    private String notes;
    private String babyName;
    private Long babyId;
    private String temperatureStatus; // Normal, High, Low
    private String heartRateStatus;   // Normal, High, Low
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
