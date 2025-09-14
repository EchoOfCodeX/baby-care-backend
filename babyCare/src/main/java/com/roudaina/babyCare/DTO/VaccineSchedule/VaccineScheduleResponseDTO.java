package com.roudaina.babyCare.DTO.VaccineSchedule;

import com.babycare.entity.VaccineSchedule.VaccineStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class VaccineScheduleResponseDTO {


    private Long scheduleId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduledDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate administeredDate;

    private VaccineStatus status;
    private String notes;

    private String babyName;
    private Long babyId;

    private String vaccineName;
    private Long vaccineId;

    private Integer daysOverdue; // Computed field for overdue schedules

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;


}
