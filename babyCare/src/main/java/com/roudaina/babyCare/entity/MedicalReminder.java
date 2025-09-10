package com.roudaina.babyCare.entity;

import com.roudaina.babyCare.Enum.RecurrencePattern;
import com.roudaina.babyCare.Enum.ReminderStatus;
import com.roudaina.babyCare.Enum.ReminderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_reminders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalReminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reminder-id")
    private long id;


    @NotNull(message = "نوع التذكير مطلوب")
    @Enumerated(EnumType.STRING)
    @Column(name = "reminder_type", nullable = false)
    private ReminderType reminderType;


    @NotBlank(message = "عنوان التذكير مطلوب")
    @Size(max = 200, message = "العنوان يجب أن يكون أقل من 200 حرف")
    @Column(name = "title", nullable = false, length = 200)
    private String title;


    @NotNull(message = "تاريخ التذكير مطلوب")
    @Future(message = "تاريخ التذكير يجب أن يكون في المستقبل")
    @Column(name = "reminder_date", nullable = false)
    private LocalDateTime reminderDate;


    @NotNull(message = "حالة التذكير مطلوبة")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReminderStatus status;


    private String description;



    @Column(name = "is_recurring")
    private Boolean isRecurring = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "recurrence_pattern")
    private RecurrencePattern recurrencePattern;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    //MMMM
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", nullable = false)
    @ToString.Exclude
    private Baby baby;

}
