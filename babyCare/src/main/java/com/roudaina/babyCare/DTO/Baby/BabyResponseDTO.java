package com.roudaina.babyCare.DTO.Baby;

import com.roudaina.babyCare.Enum.Gender;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BabyResponseDTO {

    private Long babyId;
    private String babyName;
    private Gender gender;
    private LocalDate BirthDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    // Parent information
    private Long parentId;
    private String parentName;
    private String email;

    // Calculated fields
    private Integer ageInMonths;
    private Integer ageInDays;
    private String ageDescription;

}
