package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.util.CommonlUtil;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProductService implements IProductService {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    public ResponseEntity<Resource> downloadFile(String code) {
        Resource resource = null;
        String id = code.substring(0, code.length() - 2);
        int idDecode = Integer.parseInt(CommonlUtil.decode64(id));
        Optional<Product> opProduct = products.stream().filter(e -> e.getId() == idDecode).findFirst();

        String fileName = "";
        String mime = "";
        if (opProduct.isPresent()) {
            String path = opProduct.get().getPath();
            resource = loadFileAsResource(path);
            fileName = opProduct.get().getName();
            mime = opProduct.get().getFileType();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mime))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    public Resource loadFileAsResource(String filePath) {
        Resource resource = null;
        try {
            resource = new UrlResource(Paths.get(filePath).toUri());
            if (resource.exists())
                return resource;
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return resource;
    }
}
