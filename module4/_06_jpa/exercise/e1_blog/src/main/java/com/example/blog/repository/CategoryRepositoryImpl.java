package com.example.blog.repository;

import com.example.blog.model.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Category> findAll() {
        TypedQuery<Category> query = em.createQuery("select c from Category c", Category.class);
        return query.getResultList();
    }
}
