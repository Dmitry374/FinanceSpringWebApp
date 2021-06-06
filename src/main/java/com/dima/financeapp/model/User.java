package com.dima.financeapp.model;

import com.dima.financeapp.common.Constants;
import com.dima.financeapp.model.dto.UserDto;
import com.dima.financeapp.model.request.RegisterUser;
import com.dima.financeapp.model.request.UserEditRequest;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String email;
    @Column(name = "photo_url")
    private String photoUrl;
    private String password;
    private String datebirth;
    private String gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Bill> bills = new ArrayList<>();

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
    }

    public static User from(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPhotoUrl(userDto.getPhotoUrl());
        user.setPassword(userDto.getPassword());
        user.setDatebirth(userDto.getDatebirth());
        user.setGender(userDto.getGender());
        return user;
    }

    public static User from(RegisterUser registerUser) {
        User user = new User();
        user.setName(registerUser.getName());
        user.setSurname(Constants.EMPTY_STRING);
        user.setEmail(registerUser.getEmail());
        user.setPhotoUrl(Constants.EMPTY_STRING);
        user.setPassword(registerUser.getPassword());
        user.setDatebirth(Constants.EMPTY_STRING);
        user.setGender(Constants.EMPTY_STRING);
        return user;
    }

    public static User from(UserEditRequest userEditRequest) {
        User user = new User();
        user.setName(userEditRequest.getName());
        user.setSurname(userEditRequest.getSurname());
        user.setEmail(userEditRequest.getEmail());
        user.setPhotoUrl(userEditRequest.getPhotoUrl());
        user.setDatebirth(userEditRequest.getDatebirth());
        user.setGender(userEditRequest.getGender());
        return user;
    }
}
