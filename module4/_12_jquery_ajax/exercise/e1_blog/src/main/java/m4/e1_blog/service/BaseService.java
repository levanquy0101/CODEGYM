package m4.e1_blog.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T save(T t);
}
