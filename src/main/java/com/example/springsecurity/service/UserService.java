package com.example.springsecurity.service;

import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.dto.UserPasswordDto;
import com.example.springsecurity.dto.mapper.UserConverter;
import com.example.springsecurity.exception.NotFoundException;
import com.example.springsecurity.model.User;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserConverter userConverter;

    public UserService(UserRepository repository, UserConverter userConverter) {
        this.repository = repository;
        this.userConverter = userConverter;
    }

    protected User getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not found entity by id: " + id));
    }

    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(userConverter::toUserDto)
                .toList();
    }

    public UserDto findById(String id) {
        return userConverter.toUserDto(getById(id));
    }

    public UserDto add(UserPasswordDto userDto) {
        return userConverter.toUserDto(repository.save(userConverter.toUser(userDto)));
    }

    public UserDto update(UserDto userDto) {
        var user = getById(userDto.getId());
        return userConverter.toUserDto(repository.save(userConverter.toUser(userDto, user.getPassword())));
    }

    public void deleteById(String id) {
        findById(id);
        repository.deleteById(id);
    }

    protected User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Could not found user by username: " + username));
    }

    public UserDto findByUsername(String id) {
        return userConverter.toUserDto(getByUsername(id));
    }

}
