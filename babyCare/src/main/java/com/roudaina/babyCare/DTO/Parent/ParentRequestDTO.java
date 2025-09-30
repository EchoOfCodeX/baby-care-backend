package com.roudaina.babyCare.DTO.Parent;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParentRequestDTO {




        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name must be less than 100 characters")
        private String name;

      //  @NotBlank(message = "Username is required")
       // @Size(min = 3, max = 50, message = "Username must be between 3-50 characters")
        //private String username;

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters long")
        private String password;

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email address")
        private String email;



}
