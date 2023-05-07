package gic.i4c.GicCafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Drink_Order;
import gic.i4c.GicCafe.model.Drink_Size;


public interface DrinkOrderRepository extends JpaRepository <Drink_Order, Integer> {

}
