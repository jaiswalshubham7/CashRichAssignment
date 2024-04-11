package com.assignment.cashrichassignment.Services;

import com.assignment.cashrichassignment.Models.User;

public interface UserService {
    public User registerUser(String username, String email, String password, String firstName, String lastName, String mobileNumber);
    public User loginUser(String username, String password);
    public User updateUserByUsername(String username, String password, String firstName, String lastName, String mobileNumber);
}
