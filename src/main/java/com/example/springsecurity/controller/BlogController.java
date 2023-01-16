package com.example.springsecurity.controller;

import com.example.springsecurity.dto.BlogDto;
import com.example.springsecurity.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<BlogDto>> findAll() {
        return ResponseEntity.ok(blogService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(blogService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BlogDto> add(@RequestBody BlogDto userDto) {
        return ResponseEntity.ok(blogService.add(userDto));
    }

    @PutMapping
    public ResponseEntity<BlogDto> update(@RequestBody BlogDto userDto) {
        return ResponseEntity.ok(blogService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        blogService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
