package com.assignment.cashrichassignment.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
}
