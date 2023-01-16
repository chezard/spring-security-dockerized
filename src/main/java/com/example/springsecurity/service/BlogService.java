package com.example.springsecurity.service;

import com.example.springsecurity.dto.BlogDto;
import com.example.springsecurity.dto.mapper.BlogConverter;
import com.example.springsecurity.exception.NotFoundException;
import com.example.springsecurity.model.Blog;
import com.example.springsecurity.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository repository;
    private final BlogConverter blogConverter;

    public BlogService(BlogRepository repository, BlogConverter blogConverter) {
        this.repository = repository;
        this.blogConverter = blogConverter;
    }

    protected Blog getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not found entity by id: " + id));
    }

    public List<BlogDto> findAll() {
        return repository.findAll().stream()
                .map(blogConverter::toBlogDto)
                .toList();
    }

    public BlogDto findById(String id) {
        return blogConverter.toBlogDto(getById(id));
    }

    public BlogDto add(BlogDto blogDto) {
        var addedBlog = repository.save(blogConverter.toBlog(blogDto));
        return blogConverter.toBlogDto(addedBlog);
    }

    public BlogDto update(BlogDto blogDto) {
        findById(blogDto.getId());
        return blogConverter.toBlogDto(repository.save(blogConverter.toBlog(blogDto)));
    }

    public void deleteById(String id) {
        findById(id);
        repository.deleteById(id);
    }

}
