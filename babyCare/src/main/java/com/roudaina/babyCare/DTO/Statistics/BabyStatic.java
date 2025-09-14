package com.roudaina.babyCare.DTO.Statistics;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BabyStatic {

    private Long babyId;
    private String babyName;
    private Integer totalHealthRecords;
    private Integer totalVaccines;
    private Integer completedVaccines;
    private Integer overdueVaccines;
    private Integer activeReminders;
    private String lastCheckupDate;
    private Double completionPercentage;



}
