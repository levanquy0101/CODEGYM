package m4.e1_blog.controller.rest;

import m4.e1_blog.model.Blog;
import m4.e1_blog.model.Category;
import m4.e1_blog.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<List<Blog>> findBlogsById(@PathVariable int id){
        return new ResponseEntity<>(categoryService.findBlogsByCategoryId(id), HttpStatus.OK) ;
    }
}
