package com.roudaina.babyCare.entity;

import com.roudaina.babyCare.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "babies")
public class Baby {
     @Id
     @Column(name = "baby_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @NotBlank(message = "Childs name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    @Column(name = "name", nullable = false, length = 100)
    private String name;


    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;



    @Min(value = 50, message = "Heart rate must be greater than 50")
    @Max(value = 200, message ="Heart rate must be less than 200")
    @Column(name = "current_heart_rate")
    private Integer currentHeartRate;




    @DecimalMin(value = "30.0", message = "Temperature must be greater than 30")
    @DecimalMax(value = "45.0", message = "Temperature must be less than 45")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "current_temperature", precision = 4, scale = 2)
    private double currentTemperature;


    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past ")
    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birth;



    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    //mmmmmmmm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = false)
    @ToString.Exclude
    private Parent parent;

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<HealthRecord> healthRecords;

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<VaccineSchedule> vaccineSchedules;

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<MedicalReminder> medicalReminders;




}
