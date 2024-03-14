package m4.e1_blog.service;

import m4.e1_blog.model.Blog;
import m4.e1_blog.repository.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements BaseService<Blog>{
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Page<Blog> find(String q, Pageable pageable){
        if (q.isEmpty()) {
            return blogRepository.findAll(pageable);
        }

        return blogRepository.findByTitleContaining(q, pageable);
    }
}
