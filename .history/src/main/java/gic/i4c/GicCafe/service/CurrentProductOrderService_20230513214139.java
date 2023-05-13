package gic.i4c.GicCafe.service;

import java.util.List;

import gic.i4c.GicCafe.model.Current_product_order;

public interface CurrentProductOrderService {
    List<Current_product_order> getAllOrders();

    Current_product_order saveOrder(Current_product_order current_drink_order);

    Current_product_order getOrderById(Integer id);

    void deleteOrder(Integer id);

    String getAllOrderIds();

    Float getTotalPrice();

    void deleteAllOrders();
}
