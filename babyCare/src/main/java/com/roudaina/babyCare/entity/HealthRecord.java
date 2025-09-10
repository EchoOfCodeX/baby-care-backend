package com.roudaina.babyCare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "health_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordId")
    private long id;


private LocalDateTime date;


    @Min(value = 50, message = "Heart rate must be greater than 50")
    @Max(value = 200, message =("Heart rate must be less than 200"))
    @Column(name = "heartrate")
     private int heartRate;


    @Size(max = 1000, message = "Notes must be less than 1000 characters")
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;


    @DecimalMin(value = "30.0", message = "Temperature must be greater than 30")
    @DecimalMax(value = "45.0", message = "Temperature must be less than 45")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "temperature", precision = 4, scale = 2)
    private double temperature;



    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    //mmmmmm

      @ManyToOne(fetch = FetchType.LAZY)
       @JoinColumn(name = "baby-id",nullable = false)
       @ToString.Exclude
    private Baby baby;

}
