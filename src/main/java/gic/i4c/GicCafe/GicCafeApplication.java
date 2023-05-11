package gic.i4c.GicCafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gic.i4c.GicCafe.model.Addons;
import gic.i4c.GicCafe.model.Product_Size;
import gic.i4c.GicCafe.repository.AddonsRepository;
import gic.i4c.GicCafe.repository.ProductSizeRepository;
// import gic.i4c.GicCafe.service.DrinkSizeService;


@SpringBootApplication
public class GicCafeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GicCafeApplication.class, args);
	}

	@Autowired
	private ProductSizeRepository productSizeRepository;

	@Autowired
	private AddonsRepository addonsRepository;

	@Override
	public void run(String... args) throws Exception {
		if(productSizeRepository.count() == 0){
			Product_Size product_size_small = new Product_Size("small", (float) 0);
			Product_Size product_size_medium = new Product_Size("medium", (float) 0.25);
			Product_Size product_size_large = new Product_Size("large", (float) 0.5);
			
			productSizeRepository.save(product_size_small);
			productSizeRepository.save(product_size_medium);
			productSizeRepository.save(product_size_large);
			
		}

		if(addonsRepository.count() == 0) {
			Addons cream = new Addons("cream", 1);
			Addons sugar25 = new Addons("sugar", 25);
			Addons sugar50 = new Addons("sugar", 50);
			Addons sugar75 = new Addons("sugar", 75);
			Addons sugar100 = new Addons("sugar", 100);
			
			addonsRepository.save(cream);
			addonsRepository.save(sugar25);
			addonsRepository.save(sugar50);
			addonsRepository.save(sugar75);
			addonsRepository.save(sugar100);
			
			
		}
	}

}

