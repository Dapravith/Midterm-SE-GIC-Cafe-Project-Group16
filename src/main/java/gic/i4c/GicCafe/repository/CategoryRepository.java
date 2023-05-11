package gic.i4c.GicCafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Drink_category;
import gic.i4c.GicCafe.model.Product_category;

public interface CategoryRepository extends JpaRepository <Product_category, Integer> {

    Product_category save(Product_category drink_category);

    List<Product_category> findByType(String string);
    
}
