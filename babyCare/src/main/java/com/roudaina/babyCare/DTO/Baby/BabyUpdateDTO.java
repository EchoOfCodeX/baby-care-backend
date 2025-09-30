package com.roudaina.babyCare.DTO.Baby;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BabyUpdateDTO {




    @Size(max = 100, message = "Name must be less than 100 characters")
    private String babyName;

    @NotNull(message = "تاريخ الميلاد مطلوب")
    private LocalDate birthDate;

    @NotBlank(message = "الجنس مطلوب (MALE/FEMALE)")
    private String gender;
}
