package m4.product.service;

import m4.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    void delete(int id);
    Optional<Product> getById(int id);
    List<Product> search(String name);
}
