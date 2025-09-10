package com.roudaina.babyCare.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class vaccineSchedule {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "scheduleId")
    private long id;
private String status;
private int doseNumber;
private LocalDateTime date;

}
