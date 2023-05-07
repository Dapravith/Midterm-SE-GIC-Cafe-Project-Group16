package gic.i4c.GicCafe.service;

import java.util.List;

import gic.i4c.GicCafe.model.Drink_category;

public interface CategoryService {
    Drink_category saveCategory(Drink_category drink_category);
    List<Drink_category> getAllCategories();
    Drink_category getCategoryById(Integer id);
}
