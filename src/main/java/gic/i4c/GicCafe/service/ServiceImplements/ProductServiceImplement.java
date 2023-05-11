package gic.i4c.GicCafe.service.ServiceImplements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import gic.i4c.GicCafe.model.Product;
import gic.i4c.GicCafe.model.Product_category;
import gic.i4c.GicCafe.repository.ProductRepository;
import org.springframework.util.StringUtils;

import gic.i4c.GicCafe.service.CategoryService;
import gic.i4c.GicCafe.service.ProductService;

@Service
public class ProductServiceImplement implements ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;

    public ProductServiceImplement(ProductRepository productRepository, CategoryService categoryService) {
        super();
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Product saveProduct(Product product, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..") || fileName.isEmpty())
		{
			System.out.println("not a a valid file");
		}

        if(!product.isEmpty()){
            try {
                product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return productRepository.save(product);
        }
        else{
            return null;
        }
    }

    @Override
    public List<Product> getAllDrinks() {
        List <Product> allProduct = productRepository.findAll();
        List <Product_category> drinkCategories = categoryService.getDrinkCategories();
        List <Product> drinkProducts = new ArrayList<Product>();

        for(Product_category category: drinkCategories){
            for(Product drink: allProduct){
                if(drink.getCategory_id().equals(category.getId())){
                    drinkProducts.add(drink);
                }
            }
        }
        return drinkProducts;
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getFirstProduct() {
        return productRepository.findAll().get(0);
    }

    @Override
    public List<Product> getAllFoods() {
        List <Product> allProduct = productRepository.findAll();
        List <Product_category> foodCategories = categoryService.getFoodCategories();
        List <Product> foodProducts = new ArrayList<Product>();

        for(Product_category category: foodCategories){
            for(Product drink: allProduct){
                if(drink.getCategory_id().equals(category.getId())){
                    foodProducts.add(drink);
                }
            }
        }
        return foodProducts;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    
    
}
