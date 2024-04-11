package com.assignment.cashrichassignment.Services;

import com.assignment.cashrichassignment.Exceptions.InvalidPasswordException;
import com.assignment.cashrichassignment.Exceptions.UserAlreadyExistException;
import com.assignment.cashrichassignment.Exceptions.UserNotFoundException;
import com.assignment.cashrichassignment.Models.User;
import com.assignment.cashrichassignment.Repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AppUserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public User registerUser(String username,
                             String email,
                             String password,
                             String firstName,
                             String lastName,
                             String mobileNumber) {

        User userWithUsername = userRepository.findByUsername(username);
        User userWithEmail = userRepository.findByEmail(email);

        if (userWithUsername != null) {
            throw new UserAlreadyExistException("Username already exist");
        }
        if (userWithEmail != null) {
            throw new UserAlreadyExistException("Email already exist");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMobileNumber(mobileNumber);

        return userRepository.save(user);
    }
    public User loginUser(String username, String password) {

        User user = getUserByUsername(username);
        if(!bCryptPasswordEncoder.matches(password, user.getPassword())){
            throw new InvalidPasswordException("Invalid password");
        }
        return user;
    }

    @Override
    public User updateUserByUsername(String username, String password, String firstName, String lastName, String mobileNumber) {
        User user = getUserByUsername(username);
        if (password != null) {
            user.setPassword(bCryptPasswordEncoder.encode(password));
        }
        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (lastName != null) {
            user.setLastName(lastName);
        }
        if (mobileNumber != null) {
            user.setMobileNumber(mobileNumber);
        }
        return userRepository.save(user);
    }
}
