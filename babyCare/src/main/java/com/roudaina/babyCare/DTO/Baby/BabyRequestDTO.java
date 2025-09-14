package com.roudaina.babyCare.DTO.Baby;

import com.roudaina.babyCare.Enum.Gender;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BabyRequestDTO {

    @NotBlank(message = "Baby name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @DecimalMin(value = "30.0", message = "Temperature must be above 30°C")
    @DecimalMax(value = "45.0", message = "Temperature must be below 45°C")
    private BigDecimal currentTemperature;

    @Min(value = 50, message = "Heart rate must be above 50")
    @Max(value = 200, message = "Heart rate must be below 200")
    private Integer currentHeartRate;
}




