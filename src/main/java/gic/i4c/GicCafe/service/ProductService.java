package gic.i4c.GicCafe.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import gic.i4c.GicCafe.model.Product;

public interface ProductService {
    Product saveProduct(Product product, MultipartFile file);
    List<Product> getAllDrinks();
    List<Product> getAllFoods();
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    void deleteProduct(Integer id);
    Product getFirstProduct();
}
