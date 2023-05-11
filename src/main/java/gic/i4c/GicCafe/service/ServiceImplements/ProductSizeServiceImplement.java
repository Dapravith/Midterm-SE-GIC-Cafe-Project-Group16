package gic.i4c.GicCafe.service.ServiceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Product_Size;
import gic.i4c.GicCafe.repository.ProductSizeRepository;
import gic.i4c.GicCafe.service.ProductSizeService;

@Service
public class ProductSizeServiceImplement implements ProductSizeService {
    private ProductSizeRepository productSizeRepository;

    public ProductSizeServiceImplement(ProductSizeRepository productSizeRepository) {
        super();
        this.productSizeRepository = productSizeRepository;
    }

    @Override
    public Boolean isEmpty() {
        Long count = productSizeRepository.count();
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Product_Size saveProduct_size(Product_Size product_size) {
        return productSizeRepository.save(product_size);
    }

    @Override
    public List<Product_Size> getAllProductSizes() {
        return productSizeRepository.findAll();
    }

    @Override
    public Product_Size getSizeById(Integer id) {
        return productSizeRepository.findById(id).get();
    }
    
}
