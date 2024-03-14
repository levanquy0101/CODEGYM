package m4.e1_blog.service;

import m4.e1_blog.model.Blog;
import m4.e1_blog.repository.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }

    public Page<Blog> find(String q, Pageable pageable){
        if (q.isEmpty()) {
            return blogRepository.findAll(pageable);
        }

        return blogRepository.findByTitleContaining(q, pageable);
    }
}
