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


@Entity
@Table(name = "vaccines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class vaccine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccineId")
    private Long Id;

    @NotBlank(message = "اسم اللقاح مطلوب")
    @Size(max = 100, message = "اسم اللقاح يجب أن يكون أقل من 100 حرف")
    @Column(name = "vaccine_name", unique = true, nullable = false, length = 100)
    private String vaccineName;


    @Size(max = 1000, message = "الوصف يجب أن يكون أقل من 1000 حرف")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    @NotNull(message = "عدد الجرعات المطلوبة مطلوب")
    @Min(value = 1, message = "عدد الجرعات يجب أن يكون على الأقل 1")
    @Column(name = "required_doses", nullable = false)
    private int dosesRequired;


    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    //mmmmmmm

}


