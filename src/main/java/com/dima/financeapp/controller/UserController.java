package com.dima.financeapp.controller;

import com.dima.financeapp.model.User;
import com.dima.financeapp.model.dto.UserDto;
import com.dima.financeapp.model.request.AuthUser;
import com.dima.financeapp.model.request.RegisterUser;
import com.dima.financeapp.model.request.UserEditRequest;
import com.dima.financeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.getUsers();
        List<UserDto> usersDto = users.stream().map(UserDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable final Long id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<UserDto> editUser(@PathVariable final Long id,
                                            @RequestBody final UserEditRequest userEditRequest) {
        User user = userService.editUser(id, User.from(userEditRequest));
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody final RegisterUser registerUser) {
        User user = userService.addUser(User.from(registerUser));
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody final AuthUser authUser) {
        User user = userService.getUserByEmailAndPassword(authUser.getEmail(), authUser.getPassword());
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }

    @PostMapping("/sign_in")
    public ResponseEntity<UserDto> signInUser(@RequestParam("email") String email) {
        User user = userService.getUserByEmail(email);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }
}
