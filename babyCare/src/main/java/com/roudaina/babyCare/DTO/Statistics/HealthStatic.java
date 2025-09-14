package com.roudaina.babyCare.DTO.Statistics;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthStatic {

    private Double averageTemperature;
    private Double averageHeartRate;
    private Integer totalRecords;
    private String period; // "الشهر الماضي", "الأسبوع الماضي"

}
