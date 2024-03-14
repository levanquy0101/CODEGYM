package m4.e1_blog.controller.rest;

import m4.e1_blog.model.Blog;
import m4.e1_blog.model.Category;
import m4.e1_blog.service.BlogService;
import m4.e1_blog.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> findAll(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id) {
        Optional<Blog> blogOptional = blogService.findById(id);

        return blogOptional.map(blog -> new ResponseEntity<>(blog, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
