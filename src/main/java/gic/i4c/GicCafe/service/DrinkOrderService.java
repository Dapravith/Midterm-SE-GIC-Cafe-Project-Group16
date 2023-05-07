package gic.i4c.GicCafe.service;

import java.util.List;

import gic.i4c.GicCafe.model.Drink_Order;

public interface  DrinkOrderService {
    List<Drink_Order> getAllOrders();
    Drink_Order saveOrder(Drink_Order drink_order);
    Drink_Order getOrderById(Integer id);
}
