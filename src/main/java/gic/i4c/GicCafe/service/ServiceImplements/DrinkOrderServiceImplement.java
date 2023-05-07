package gic.i4c.GicCafe.service.ServiceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Drink_Order;
import gic.i4c.GicCafe.repository.DrinkOrderRepository;
import gic.i4c.GicCafe.service.DrinkOrderService;

@Service
public class DrinkOrderServiceImplement implements DrinkOrderService {
    private DrinkOrderRepository drinkOrderRepository;

    public DrinkOrderServiceImplement(DrinkOrderRepository drinkOrderRepository) {
        super();
        this.drinkOrderRepository = drinkOrderRepository;
    }


    @Override
    public List<Drink_Order> getAllOrders() {
        return drinkOrderRepository.findAll();
    }

    @Override
    public Drink_Order saveOrder(Drink_Order drink_order) {
        return drinkOrderRepository.save(drink_order) ;
    }


    @Override
    public Drink_Order getOrderById(Integer id) {
        return drinkOrderRepository.findById(id).get();
    }

    
}
