package m4.e1_blog.controller.rest;

import m4.e1_blog.model.Blog;
import m4.e1_blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    private final BlogService blogRepository;

    public BlogController(BlogService blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> search(@RequestParam String q){
        return new ResponseEntity<>(blogRepository.findByTitleOrContent(q), HttpStatus.OK);
    }
}
