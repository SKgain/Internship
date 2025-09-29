package com.example.basicSpringPractice.DTO.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerProfileRequestDTO {
    @NotBlank(message = "Must be provide an address")
    private String address;

    @NotBlank(message = "Must be provide a phone number")
    @Pattern(
            regexp = "^(?:\\+8801[3-9][0-9]{8}|01[3-9][0-9]{8})$",
            message = "Invalid Bangladeshi phone number"
    )
    private String phone;


}
