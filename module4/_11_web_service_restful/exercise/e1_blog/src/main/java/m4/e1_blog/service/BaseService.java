package m4.e1_blog.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    List<T> findAll();
    Optional<T> findById(int id);
    T save(T t);
    void deleteById(int id);
}
