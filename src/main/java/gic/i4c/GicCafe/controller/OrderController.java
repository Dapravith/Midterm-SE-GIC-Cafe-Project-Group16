package gic.i4c.GicCafe.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gic.i4c.GicCafe.model.Drink_Order;
import gic.i4c.GicCafe.service.DrinkOrderService;

@RestController
public class OrderController {
    private DrinkOrderService drinkOrderService;

    public OrderController(DrinkOrderService drinkOrderService) {
        super();
        this.drinkOrderService = drinkOrderService;
    }

    @PostMapping("/save_order")
    public String saveOrder(@ModelAttribute("order") Drink_Order drink_order){
        drinkOrderService.saveOrder(drink_order);
        return "redirect:/list_drink";
    }
}
