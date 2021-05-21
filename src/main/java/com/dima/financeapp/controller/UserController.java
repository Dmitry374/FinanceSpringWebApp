package com.dima.financeapp.controller;

import com.dima.financeapp.common.BaseResponses;
import com.dima.financeapp.model.User;
import com.dima.financeapp.model.dto.UserDto;
import com.dima.financeapp.model.request.AuthUser;
import com.dima.financeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody final UserDto userDto) {
        User user = userService.getUserByEmail(userDto.getEmail());
        if (user != null) {
            return new ResponseEntity<>(BaseResponses.USER_EXISTS_RESPONSE, HttpStatus.OK);
        }

        User newUser = userService.addUser(User.from(userDto));
        if (newUser == null) {
            return new ResponseEntity<>(BaseResponses.REGISTRATION_ERROR_RESPONSE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(BaseResponses.RESPONSE_SUCCESS, HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody final AuthUser authUser) {
        User user = userService.getUserByEmailAndPassword(authUser.getEmail(), authUser.getPassword());
        if (user == null) {
            return new ResponseEntity<>(BaseResponses.NO_SUCH_USER_RESPONSE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(BaseResponses.RESPONSE_SUCCESS, HttpStatus.OK);
        }
    }
}
