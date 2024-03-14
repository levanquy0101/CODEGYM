package service;

import model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    void delete(int id);
    List<Product> search(String name);
}
