package com.example.springsecurity.dto.mapper;

import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.dto.UserPasswordDto;
import com.example.springsecurity.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public User toUser(UserDto from) {
        if (from == null) return null;

        System.out.println(from);

        return new User(
                from.getId(),
                from.getUsername(),
                null,
                from.getRole()
        );
    }

    public User toUser(UserDto from, String password) {
        if (from == null) return null;

        return new User(
                from.getId(),
                from.getUsername(),
                password,
                from.getRole()
        );
    }

    public User toUser(UserPasswordDto from) {
        if (from == null) return null;

        return new User(
                from.getId(),
                from.getUsername(),
                from.getPassword(),
                from.getRole()
        );
    }

    public UserDto toUserDto(User from) {
        if (from == null) return null;

        return new UserDto(
                from.getId(),
                from.getUsername(),
                from.getRole()
        );
    }

    public UserPasswordDto toUserPasswordDto(User from) {
        if (from == null) return null;

        return new UserPasswordDto(
                from.getId(),
                from.getUsername(),
                from.getPassword(),
                from.getRole()
        );
    }

}