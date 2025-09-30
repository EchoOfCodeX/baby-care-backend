package com.roudaina.babyCare.DTO.Baby;

import com.roudaina.babyCare.Enum.Gender;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BabyRequestDTO {

    @NotBlank(message = "Baby name is required")
    @Size(min = 2, max = 50, message = "Baby name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Parent ID is required")
    private Long parentId;
}
