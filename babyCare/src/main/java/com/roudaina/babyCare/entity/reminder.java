package com.roudaina.babyCare.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reminder-id")
    private long id;

    private String type;
    private  String title;
    private String description;
    private LocalDateTime reminderDateTime;
    private String status;

}
