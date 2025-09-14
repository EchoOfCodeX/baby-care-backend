package com.roudaina.babyCare.DTO.Baby;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BabyStatisticsDTO {




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
