package com.example.blog.repository;

import com.example.blog.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CategoryRepository {
    List<Category> findAll();
}
