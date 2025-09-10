package com.roudaina.babyCare.entity;

import com.roudaina.babyCare.Enum.VaccineStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "vaccine_schedules")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccineSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "scheduleId")
    private long id;

    @NotNull(message = "Appointment date is required")
    @Future(message = "Appointment date must be in the future")
    @Column(name = "scheduled_date", nullable = false)
    private LocalDateTime scheduledDate;


    @NotNull(message = "Vaccine status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VaccineStatus status;


    @Column(name = "administered_date")
    private LocalDate administeredDate;

    @Size(max = 1000, message = "Notes must be less than 1000 characters")
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


  //mmmmmm

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", nullable = false)
    @ToString.Exclude
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaccine_id", nullable = false)
    @ToString.Exclude
    private Vaccine vaccine;


}
