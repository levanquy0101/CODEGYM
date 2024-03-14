package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private List<Product> products= new ArrayList<>();

    public ProductServiceImpl(){
        products.add(new Product(1, "Nokia 590", 123, "d1", "Nokia"));
        products.add(new Product(2, "SamSung A80", 123, "d2", "Samsung"));
        products.add(new Product(3, "Iphone 13", 123, "d3", "Apple"));
        products.add(new Product(4, "Test 13", 123, "d3", "Test"));
        products.add(new Product(5, "LG 139", 123, "d3", "LG"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        if(product.getId()>0){
            int index= products.indexOf(product);
            products.set(index, product);
        }
        else {
            int id= products.get(products.size()-1).getId()+ 1;
            product.setId(id);
            products.add(product);
        }
    }

    @Override
    public void delete(int id) {
//        for (int i = 0; i < products.size(); i++) {
//            if(products.get(i).getId()== id){
//                products.remove(i);
//                break;
//            }
//        }

        products.removeIf(e-> e.getId()== id);
    }

    @Override
    public List<Product> search(String name) {
//        List<Product> res= new ArrayList<>();
//        for (int i = 0; i < products.size(); i++) {
//            if(products.get(i).getName().contains(name)){
//                res.add(products.get(i));
//            }
//        }
//        return res;

        return products.stream().filter(f-> f.getName().contains(name)).collect(Collectors.toList());
    }
}
