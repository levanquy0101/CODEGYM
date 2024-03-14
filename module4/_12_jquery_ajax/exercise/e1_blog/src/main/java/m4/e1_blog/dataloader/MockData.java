package m4.e1_blog.dataloader;

import m4.e1_blog.model.Blog;
import m4.e1_blog.model.Category;
import m4.e1_blog.service.BlogService;
import m4.e1_blog.service.CategoryService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MockData implements ApplicationListener<ContextRefreshedEvent> {
    private final BlogService blogService;
    private final CategoryService categoryService;

    public MockData(BlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            Category category1 = null;
            Category category2 = null;

            if(categoryService.findAll().isEmpty()){
                category1 = categoryService.save(new Category(1, "Sport"));
                category2 = categoryService.save(new Category(2, "World"));
                categoryService.save(new Category(3, "News"));
            }

            if(blogService.findAll().isEmpty()){
                blogService.save(new Blog(1, "title1", "content1", "/user/images/img2.jpg", 1, LocalDate.now(), category1));
                blogService.save(new Blog(2, "title2", "content2", "/user/images/img10.jpg", 1, LocalDate.now(), category1));
                blogService.save(new Blog(3, "title3", "content3", "/user/images/img11.jpg", 1, LocalDate.now(), category2));
                blogService.save(new Blog(4, "title4", "content4", "/user/images/img15.jpg", 1, LocalDate.now(), category2));
                blogService.save(new Blog(5, "title5", "content5", "/user/images/img20.jpg", 1, LocalDate.now(), category1));
            }
        }
    }
}
