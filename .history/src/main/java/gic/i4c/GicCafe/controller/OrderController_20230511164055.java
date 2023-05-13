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
    public String saveOrder(@ModelAttribute("order") Current_product_order drink_order){
        currentDrinkOrderService.saveOrder(drink_order);
        return "redirect:/list_drink";
    }

    @GetMapping("/list_drink/delete/{id}")
    public String deleteOrder(@PathVariable Integer id){
        currentDrinkOrderService.deleteOrder(id);
        return "redirect:/list_drink";
    }
}
