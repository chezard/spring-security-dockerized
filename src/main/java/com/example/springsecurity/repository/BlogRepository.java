package com.example.springsecurity.repository;

import com.example.springsecurity.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, String> {
}
