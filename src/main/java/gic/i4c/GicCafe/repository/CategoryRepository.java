package gic.i4c.GicCafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Drink_category;

public interface CategoryRepository extends JpaRepository <Drink_category, Integer> {
    
}
