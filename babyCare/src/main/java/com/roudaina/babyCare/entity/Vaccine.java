package com.roudaina.babyCare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "vaccines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vaccine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccineId")
    private Long Id;

    @NotBlank(message = "Vaccine name is required")
    @Size(max = 100, message = "Vaccine name must be less than 100 characters")
    @Column(name = "vaccine_name", unique = true, nullable = false, length = 100)
    private String vaccineName;


    @Size(max = 1000, message = "Description must be less than 1000 characters")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    @NotNull(message = "Number of required doses is required")
    @Min(value = 1, message = "Number of doses must be at least 1")
    @Column(name = "required_doses", nullable = false)
    private int dosesRequired;


    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    //mmmmmmm


    @OneToMany(mappedBy = "vaccine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VaccineSchedule> vaccineSchedules;

}


