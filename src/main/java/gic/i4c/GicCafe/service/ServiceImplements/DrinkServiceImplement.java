package gic.i4c.GicCafe.service.ServiceImplements;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import gic.i4c.GicCafe.model.Drink;
import gic.i4c.GicCafe.repository.DrinkRepository;
import org.springframework.util.StringUtils;
import gic.i4c.GicCafe.service.DrinkService;

@Service
public class DrinkServiceImplement implements DrinkService {
    private DrinkRepository drinkRepository;

    public DrinkServiceImplement(DrinkRepository drinkRepository) {
        super();
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Drink saveDrink(Drink drink, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..") || fileName.isEmpty())
		{
			System.out.println("not a a valid file");
		}

        if(!drink.isEmpty()){
            try {
                drink.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return drinkRepository.save(drink);
        }
        else{
            return null;
        }
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink getDrinkById(Integer id) {
        return drinkRepository.findById(id).get();
    }

    @Override
    public void deleteDrink(Integer id) {
        drinkRepository.deleteById(id);
    }

    @Override
    public Drink getFirstDrink() {
        return drinkRepository.findAll().get(0);
    }
}
