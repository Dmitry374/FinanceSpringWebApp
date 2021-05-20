package com.dima.financeapp.model;

import com.dima.financeapp.model.dto.UserDto;
import lombok.Data;

import javax.persistence.*;

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
    private String password;
    private String datebirth;
    private String gender;

    public static User from(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setDatebirth(userDto.getDatebirth());
        user.setGender(userDto.getGender());
        return user;
    }
}
