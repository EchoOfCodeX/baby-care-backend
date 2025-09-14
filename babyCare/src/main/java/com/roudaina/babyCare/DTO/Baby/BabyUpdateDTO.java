package com.roudaina.babyCare.DTO.Baby;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BabyUpdateDTO {




    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @DecimalMin(value = "30.0", message = "Temperature must be above 30°C")
    @DecimalMax(value = "45.0", message = "Temperature must be below 45°C")
    private BigDecimal currentTemperature;

    @Min(value = 50, message = "Heart rate must be above 50")
    @Max(value = 200, message = "Heart rate must be below 200")
    private Integer currentHeartRate;
}
