package com.roudaina.babyCare.DTO.VaccineSchedule;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccineScheduleRequestDTO{


    @NotNull(message = "Vaccine ID is required")
    private Long vaccineId;

    @NotNull(message = "Baby ID is required")
    private Long babyId;

    @NotNull(message = "Scheduled date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduledDate;

    @Size(max = 1000, message = "Notes must be less than 1000 characters")
    private String notes;



}
