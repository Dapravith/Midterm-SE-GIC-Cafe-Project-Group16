package gic.i4c.GicCafe.service.ServiceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Product_order;
import gic.i4c.GicCafe.repository.ProductOrderRepository;
import gic.i4c.GicCafe.service.ProductOrderService;

@Service
public class ProductOrderServiceImplement implements ProductOrderService {
    private ProductOrderRepository productOrderRepository;

    public ProductOrderServiceImplement(ProductOrderRepository productOrderRepository) {
        super();
        this.productOrderRepository = productOrderRepository;
    }


    @Override
    public List<Product_order> getAllOrders() {
        return productOrderRepository.findAll();
    }

    @Override
    public Product_order saveOrder(Product_order product_order) {
        return productOrderRepository.save(product_order) ;
    }


    @Override
    public Product_order getOrderById(Integer id) {
        return productOrderRepository.findById(id).get();
    }


    @Override
    public void deleteOrder(Integer id) {
        productOrderRepository.deleteById(id);
    }
    
}

