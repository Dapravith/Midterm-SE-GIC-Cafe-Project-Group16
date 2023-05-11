package gic.i4c.GicCafe.service.ServiceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Current_product_order;
import gic.i4c.GicCafe.repository.CurrentProductOrderRepository;
import gic.i4c.GicCafe.service.CurrentProductOrderService;
import gic.i4c.GicCafe.service.ProductService;
import gic.i4c.GicCafe.service.ProductSizeService;

@Service
public class CurrentProductOrderServiceImplement implements CurrentProductOrderService {
    private CurrentProductOrderRepository currentDrinkOrderRepository;
    private ProductService productService;
    private ProductSizeService drinkSizeService;

    public CurrentProductOrderServiceImplement(CurrentProductOrderRepository currentDrinkOrderRepository, ProductService productService, ProductSizeService drinkSizeService) {
        super();
        this.currentDrinkOrderRepository = currentDrinkOrderRepository;
        this.productService = productService;
        this.drinkSizeService = drinkSizeService;
    }

    @Override
    public List<Current_product_order> getAllOrders() {
        return currentDrinkOrderRepository.findAll();
    }

    @Override
    public Current_product_order saveOrder(Current_product_order current_drink_order) {
        return currentDrinkOrderRepository.save(current_drink_order);
    }

    @Override
    public Current_product_order getOrderById(Integer id) {
        return currentDrinkOrderRepository.findById(id).get();
    }

    @Override
    public void deleteOrder(Integer id) {
        currentDrinkOrderRepository.deleteById(id);;
    }

    @Override
    public String getAllOrderIds() {
        String ids = "";
        for(Current_product_order order: currentDrinkOrderRepository.findAll()){
            ids = ids + order.getId() + ",";
        }
        ids = ids.substring(0, ids.length()-1);
        return ids;
    }

    @Override
    public Float getTotalPrice() {
        Float totalPrice = (float) 0;
        for(Current_product_order order: currentDrinkOrderRepository.findAll()){
            Float orderAmount = (float) order.getAmount();
            Float orderPrice = productService.getProductById( order.getProduct_id() ).getPrice();
            Float orderSizePrice = drinkSizeService.getSizeById(order.getSize_id()).getPrice();
            totalPrice = totalPrice + ( ( ( orderPrice + orderSizePrice ) * orderAmount ) );
        }
        return totalPrice;
    }
    
    
}
