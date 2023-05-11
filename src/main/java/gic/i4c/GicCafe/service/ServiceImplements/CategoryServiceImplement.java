package gic.i4c.GicCafe.service.ServiceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Product_category;
import gic.i4c.GicCafe.repository.CategoryRepository;
import gic.i4c.GicCafe.service.CategoryService;

@Service
public class CategoryServiceImplement implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImplement(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product_category saveCategory(Product_category drink_category) {
        if(!drink_category.isEmpty()){
            return categoryRepository.save(drink_category);
        }
        else{
            return null;
        }
    }

    @Override
    public List<Product_category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Product_category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Product_category> getFoodCategories() {
        return categoryRepository.findByType("food");
    }

    @Override
    public List<Product_category> getDrinkCategories() {
        return categoryRepository.findByType("drink");
    }
    
}