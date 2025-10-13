package com.example.bank.DTO.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class SignInRequestDTO {
    @NotBlank(message = "Please provide you registered email.")
    @Email(message = "You email is not valid, please provide a valid email.")
    private String email;

    @NotBlank(message = "Password required.")
    private String password;
}
