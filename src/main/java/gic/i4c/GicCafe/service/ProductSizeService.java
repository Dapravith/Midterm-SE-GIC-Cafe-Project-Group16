package gic.i4c.GicCafe.service;

import java.util.List;

import gic.i4c.GicCafe.model.Product_Size;

public interface ProductSizeService {
    Boolean isEmpty();
    Product_Size saveProduct_size(Product_Size product_size);
    List<Product_Size> getAllProductSizes();
    Product_Size getSizeById(Integer id);
}
