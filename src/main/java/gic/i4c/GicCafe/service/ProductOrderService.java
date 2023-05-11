package gic.i4c.GicCafe.service;

import java.util.List;

import gic.i4c.GicCafe.model.Product_order;

public interface ProductOrderService {
    List<Product_order> getAllOrders();
    Product_order saveOrder(Product_order drink_order);
    Product_order getOrderById(Integer id);
    void deleteOrder(Integer id);
}