package com.assignment.cashrichassignment.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    @Id
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
}
