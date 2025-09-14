package com.roudaina.babyCare.DTO.Parent;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParentResponseDTO {


    private Long parentId;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
