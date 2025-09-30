package com.roudaina.babyCare.HeathRecordDTO;

import com.roudaina.babyCare.Enum.HeartRateStatus;
import com.roudaina.babyCare.Enum.TemperatureStatus;
import lombok.*;
import org.apache.tomcat.util.http.parser.HttpHeaderParser;

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
    private LocalDateTime recordDate;
    private Double temperature;
    private Integer heartRate;
    private String notes;
    private String  babyName;
    private Long babyId;
    private TemperatureStatus tperatureStatus; // Normal, High, Low
    private HeartRateStatus heartRateStatus;   // Normal, High, Low
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
