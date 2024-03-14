package m4.e1_blog.repository;

import m4.e1_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    List<Blog> findByTitleContainingOrContentContaining(String title, String content);
}
