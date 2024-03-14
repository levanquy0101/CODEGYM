package m4.e1_blog.controller;

import m4.e1_blog.model.Blog;
import m4.e1_blog.service.CategoryService;
import m4.e1_blog.service.BlogService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final CategoryService categoryService;
    private final BlogService blogRepository;

    public HomeController(CategoryService categoryService, BlogService blogRepository) {
        this.categoryService = categoryService;
        this.blogRepository = blogRepository;
    }

    @GetMapping("/home")
    public String home(Model model, @RequestParam(defaultValue = "") String q, Pageable pageable){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blogs", blogRepository.find(q, pageable));
        model.addAttribute("q", q);
        return "index";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Blog blog){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", blog);
        return "detail";
    }
}
