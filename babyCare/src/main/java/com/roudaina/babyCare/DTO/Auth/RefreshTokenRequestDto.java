package com.roudaina.babyCare.DTO.Auth;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class RefreshTokenRequestDto {



    @NotBlank(message = "رمز التحديث مطلوب")
    private String refreshToken;
}
