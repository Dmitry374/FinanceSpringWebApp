package com.dima.financeapp.model.dto;

import com.dima.financeapp.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    @JsonProperty("photo_url")
    private String photoUrl;
    private String password;
    private String datebirth;
    private String gender;
    @JsonProperty("bills")
    private List<BillDto> billsDto = new ArrayList<>();

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setPhotoUrl(user.getPhotoUrl());
        userDto.setPassword(user.getPassword());
        userDto.setDatebirth(user.getDatebirth());
        userDto.setGender(user.getGender());
        userDto.setBillsDto(user.getBills().stream().map(BillDto::from).collect(Collectors.toList()));
        return userDto;
    }
}
