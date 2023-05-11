package gic.i4c.GicCafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Product_order;


public interface ProductOrderRepository extends JpaRepository <Product_order, Integer> {
    
}
