package com.roudaina.babyCare.DTO.Auth;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class LoginRequestDto {

    @NotBlank(message = "اسم المستخدم مطلوب")
    private String username;

    @NotBlank(message = "كلمة المرور مطلوبة")
    private String password;

}
