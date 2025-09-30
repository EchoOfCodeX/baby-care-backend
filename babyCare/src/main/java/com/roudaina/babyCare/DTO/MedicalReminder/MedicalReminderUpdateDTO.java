package com.roudaina.babyCare.DTO.MedicalReminder;

import com.roudaina.babyCare.Enum.ReminderStatus;
import com.roudaina.babyCare.entity.MedicalReminder.*;
import com.roudaina.babyCare.Enum.RecurrencePattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalReminderUpdateDTO {




    @Size(max = 200, message = "Title must be less than 200 characters")
    private String title;

    private LocalDateTime reminderDate;

    @Size(max = 1000, message = "Notes must be less than 1000 characters")
    private String description;

    private ReminderStatus status;

    private Boolean isRecurring;

    private RecurrencePattern recurrencePattern;
}
