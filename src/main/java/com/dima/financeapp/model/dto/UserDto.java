package com.dima.financeapp.model.dto;

import com.dima.financeapp.model.User;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String datebirth;
    private String gender;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setDatebirth(user.getDatebirth());
        userDto.setGender(user.getGender());
        return userDto;
    }
}
