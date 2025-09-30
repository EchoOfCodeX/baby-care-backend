package com.roudaina.babyCare.DTO.MedicalReminder;

import com.roudaina.babyCare.Enum.RecurrencePattern;
import com.roudaina.babyCare.Enum.ReminderStatus;
import com.roudaina.babyCare.Enum.ReminderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalReminderResponseDTO {

    private Long reminderId;
    private ReminderType reminderType;
    private String title;
    private LocalDateTime reminderDate;
    private String description;
    private ReminderStatus status;
    private Boolean isRecurring;
    private RecurrencePattern recurrencePattern;
    private String babyName;
    private Long babyId;
  //  private Integer hoursUntilReminder; // for upcoming reminders
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



}
