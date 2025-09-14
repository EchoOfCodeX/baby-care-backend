package com.roudaina.babyCare.DTO.Vaccine;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccineRequestDTO {



    @NotBlank(message = "Vaccine name is required")
    @Size(max = 100, message = "Vaccine name must be less than 100 characters")
    private String vaccineName;

    @Size(max = 1000, message = "Description must be less than 1000 characters")
    private String description;

    @NotNull(message = "Required doses is required")
    @Min(value = 1, message = "Required doses must be at least 1")
    private Integer requiredDoses;

}
