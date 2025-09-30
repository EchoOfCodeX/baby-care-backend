package com.roudaina.babyCare.DTO.MedicalReminder;



import com.roudaina.babyCare.Enum.RecurrencePattern;
import com.roudaina.babyCare.Enum.ReminderStatus;
import com.roudaina.babyCare.entity.MedicalReminder.*;
import com.roudaina.babyCare.Enum.ReminderType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class MedicalReminderRequestDTO {


    @NotNull(message = "Reminder type is required")
    private ReminderType reminderType;

    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title must be less than 200 characters")
    private String title;

    @NotNull(message = "Reminder date is required")
    private LocalDateTime reminderDate;

    @Size(max = 1000, message = "Notes must be less than 1000 characters")
    private String description;

    private Boolean isRecurring = false;

    private RecurrencePattern recurrencePattern;

    @NotNull(message = "Baby ID is required")
    private Long babyId;



}
