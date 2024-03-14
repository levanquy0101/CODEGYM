package m4.e1_blog.service;

import m4.e1_blog.model.Blog;
import m4.e1_blog.model.Category;
import m4.e1_blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements BaseService<Category>{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    public List<Blog> findBlogsByCategoryId(int id){
        Optional<Category> optionalCategory = findById(id);

        if(optionalCategory.isEmpty()){
            return Collections.emptyList();
        }

        return optionalCategory.get().getBlogs();
    }
}
