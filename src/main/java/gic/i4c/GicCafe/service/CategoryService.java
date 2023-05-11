package gic.i4c.GicCafe.service;

import java.util.List;


import gic.i4c.GicCafe.model.Product_category;

public interface CategoryService {
    Product_category saveCategory(Product_category drink_category);
    List<Product_category> getAllCategories();
    Product_category getCategoryById(Integer id);
    List<Product_category> getFoodCategories();
    List<Product_category> getDrinkCategories();

}