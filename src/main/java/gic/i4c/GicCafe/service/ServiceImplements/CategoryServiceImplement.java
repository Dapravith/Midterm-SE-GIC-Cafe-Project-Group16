package gic.i4c.GicCafe.service.ServiceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Drink_category;
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
    public Drink_category saveCategory(Drink_category drink_category) {
        if(!drink_category.isEmpty()){
            return categoryRepository.save(drink_category);
        }
        else{
            return null;
        }
    }

    @Override
    public List<Drink_category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Drink_category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }

}
