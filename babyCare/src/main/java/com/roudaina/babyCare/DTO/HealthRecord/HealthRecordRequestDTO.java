package com.roudaina.babyCare.HeathRecordDTO;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthRecordRequestDTO {



    @NotNull(message = "تاريخ القياس مطلوب")
    private LocalDateTime recordDate;

    @DecimalMin(value = "30.0", message = "Temperature must be greater than 30°C")
    @DecimalMax(value = "45.0", message = "Temperature must be less than 45°C")
    private BigDecimal temperature;

    @Min(value = 50, message = "Heart rate must be greater than 50")
    @Max(value = 200, message = "Heart rate must be less than 200")
    private Integer heartRate;

    @Size(max = 1000, message = "Notes must be less than 1000 characters")
    private String notes;


    @NotNull(message = "معرّف الطفل مطلوب")
    private Long babyId;

}
