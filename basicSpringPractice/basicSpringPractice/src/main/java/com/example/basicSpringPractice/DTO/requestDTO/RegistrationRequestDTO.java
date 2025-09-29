package com.example.basicSpringPractice.DTO.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDTO {
    @NotBlank(message = "Must be provide your name")
    private String name;

    @NotBlank(message = "Must be provide an email")
    @Email(message = "Must be provide an email")
    private String email;

    @NotBlank(message = "Must be provide a password")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long and contain uppercase, lowercase, number, and special character"
    )
    private String password;

    @NotNull(message = "enter your age")
    private int age;
}
