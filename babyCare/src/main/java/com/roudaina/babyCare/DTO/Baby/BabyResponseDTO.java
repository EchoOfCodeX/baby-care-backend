package com.roudaina.babyCare.DTO.Baby;

import com.roudaina.babyCare.Enum.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BabyResponseDTO {

    private Long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private Double currentTemperature;
    private Integer currentHeartRate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    // Parent information
    private Long parentId;
    private String parentName;
    private String parentEmail;

    // Calculated fields
    private Integer ageInMonths;
    private Integer ageInDays;
    private String ageDescription;

}
