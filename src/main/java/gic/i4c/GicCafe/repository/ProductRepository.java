package gic.i4c.GicCafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Drink;
import gic.i4c.GicCafe.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product save(Product product);

}
