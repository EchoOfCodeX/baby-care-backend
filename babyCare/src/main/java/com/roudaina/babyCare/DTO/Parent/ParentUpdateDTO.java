package com.roudaina.babyCare.DTO.Parent;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParentUpdateDTO {


    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @Email(message = "Invalid email address")
    private String email;
}
