package com.example.springsecurity.dto.mapper;

import com.example.springsecurity.dto.BlogDto;
import com.example.springsecurity.model.Blog;
import org.springframework.stereotype.Service;

@Service
public class BlogConverter {

    private final UserConverter userConverter;

    public BlogConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public Blog toBlog(BlogDto from) {
        if (from == null) return null;

        return new Blog(
                from.getId(),
                userConverter.toUser(from.getUser()),
                from.getContent()
        );
    }

    public BlogDto toBlogDto(Blog from) {
        if (from == null) return null;

        return new BlogDto(
                from.getId(),
                userConverter.toUserDto(from.getUser()),
                from.getContent()
        );
    }

}