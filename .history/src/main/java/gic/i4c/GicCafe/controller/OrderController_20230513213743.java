package gic.i4c.GicCafe.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gic.i4c.GicCafe.model.Current_product_order;
import gic.i4c.GicCafe.model.Product_order;
import gic.i4c.GicCafe.service.CurrentProductOrderService;
import gic.i4c.GicCafe.service.ProductOrderService;

@RestController
public class OrderController {
    private ProductOrderService drinkOrderService;
    private CurrentProductOrderService currentDrinkOrderService;

    public OrderController(ProductOrderService drinkOrderService, CurrentProductOrderService currentDrinkOrderService) {
        super();
        this.drinkOrderService = drinkOrderService;
        this.currentDrinkOrderService = currentDrinkOrderService;
    }
    
    @PostMapping("/save_order")
    public String saveOrder(@ModelAttribute("order") Current_product_order drink_order) {
        currentDrinkOrderService.saveOrder(drink_order);
        return "redirect:/product_selection";
    }

    @GetMapping("/product_selection/delete_order/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        currentDrinkOrderService.deleteOrder(id);
        return "redirect:/product_selection";
    }

    @GetMapping("/clear_current_order")
    public String clearCurrentOrder() {
        for (Current_product_order cOrder : currentDrinkOrderService.getAllOrders()) {
            String addon_ids = cOrder.getAddon_ids();
            Integer amount = cOrder.getAmount();
            Integer product_id = cOrder.getProduct_id();
            Integer size_id = cOrder.getSize_id();
            Product_order product_Order = new Product_order(product_id, addon_ids, size_id, amount);
            drinkOrderService.saveOrder(product_Order);
        }
        currentDrinkOrderService.deleteAllOrders();
        return "redirect:/product_selection";
    }
}