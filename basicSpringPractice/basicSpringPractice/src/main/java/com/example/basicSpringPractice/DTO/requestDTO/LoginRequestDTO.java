package com.example.basicSpringPractice.DTO.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class LoginRequestDTO {

    @NotBlank(message = "Must be provide your registered email")
    @Email(message = "Must be provide your registered email")
    private String email;

    @NotBlank(message = "Must be provide your password")
    private String password;
}
