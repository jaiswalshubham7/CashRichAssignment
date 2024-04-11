package com.assignment.cashrichassignment.Controllers;

import com.assignment.cashrichassignment.DTOs.UpdateUserRequestDto;
import com.assignment.cashrichassignment.DTOs.UserDto;
import com.assignment.cashrichassignment.DTOs.UserLoginDto;
import com.assignment.cashrichassignment.Models.User;
import com.assignment.cashrichassignment.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userRequestDto) {
        User user = userService.registerUser(userRequestDto.getUsername(),
                userRequestDto.getEmail(),
                userRequestDto.getPassword(),
                userRequestDto.getFirstName(),
                userRequestDto.getLastName(),
                userRequestDto.getMobileNumber());

        return new ResponseEntity<>(
                convertUserToUserDto(user), HttpStatus.CREATED
        );
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserLoginDto userLoginDto) {
        User user = userService.loginUser(userLoginDto.getUsername(), userLoginDto.getPassword());

        return new ResponseEntity<>(
                convertUserToUserDto(user), HttpStatus.OK
        );
    }

    @PatchMapping(value = "/update/{username}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateUserProfile(@RequestBody UpdateUserRequestDto updateUserRequestDto, @PathVariable String username) {
        userService.updateUserByUsername(username, updateUserRequestDto.getPassword(),
                updateUserRequestDto.getFirstName(),
                updateUserRequestDto.getLastName(),
                updateUserRequestDto.getMobileNumber());
        return new ResponseEntity<>(
                "Done", HttpStatus.OK
        );
    }


    public UserDto convertUserToUserDto(User user) {
        return UserDto.builder().email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mobileNumber(user.getMobileNumber())
                .username(user.getUsername())
                .build();
    }

}
