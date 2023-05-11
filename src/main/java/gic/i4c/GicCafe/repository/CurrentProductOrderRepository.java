package gic.i4c.GicCafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Current_product_order;

public interface CurrentProductOrderRepository extends JpaRepository<Current_product_order, Integer> {
    
}
