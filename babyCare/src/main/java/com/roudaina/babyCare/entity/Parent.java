package com.roudaina.babyCare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "parents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parent {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private long id;



     @Size(max = 100,message = "Name must be less than 100 charaacters")
     @NotBlank(message = "Name is required")
    @Column(name = "name",nullable = false,length = 100)
    private String name;



    @Email(message = "invalid email address")
    @NotBlank(message = "email is required")
    @Column(name = "email",unique = true,nullable = false,length = 100)
    private String email;



    @NotBlank(message = "password is required")
    @Size(min = 6,message = "password must be at least 6 characters")
    @Column(name = "password",nullable = false)
    private String password;




    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;



    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    //relationships

    @OneToMany(mappedBy = "parent",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Baby> babies;


}
