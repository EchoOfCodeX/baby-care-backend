package com.roudaina.babyCare.DTO.Auth;
import com.roudaina.babyCare.DTO.Parent.ParentResponseDTO;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LoginResponseDto {

    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private Long expiresIn;
    private ParentResponseDTO parent;



}
