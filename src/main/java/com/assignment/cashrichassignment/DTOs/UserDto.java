package com.assignment.cashrichassignment.DTOs;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username must contain only characters and digits")
    @Size(min = 4, max = 15, message = "Username must be between 4 and 15 characters")
    private String username;
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;

}
