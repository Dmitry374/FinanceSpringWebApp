package com.dima.financeapp.service;

import com.dima.financeapp.model.User;
import com.dima.financeapp.model.exception.UserNotFoundException;
import com.dima.financeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User editUser(Long id, User user) {
        User userToEdit = getUser(id);
        userToEdit.setName(user.getName());
        userToEdit.setSurname(user.getSurname());
        userToEdit.setPhotoUrl(user.getPhotoUrl());
        userToEdit.setDatebirth(user.getDatebirth());
        userToEdit.setGender(user.getGender());
        return userToEdit;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id));
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }
}
