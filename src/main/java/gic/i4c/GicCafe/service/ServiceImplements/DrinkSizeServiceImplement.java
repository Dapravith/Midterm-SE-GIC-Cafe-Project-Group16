package gic.i4c.GicCafe.service.ServiceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Drink_Size;
import gic.i4c.GicCafe.repository.DrinkSizeRepository;
import gic.i4c.GicCafe.service.DrinkSizeService;

@Service
public class DrinkSizeServiceImplement implements DrinkSizeService {
    private DrinkSizeRepository drinkSizeRepository;

    public DrinkSizeServiceImplement(DrinkSizeRepository drinkSizeRepository) {
        super();
        this.drinkSizeRepository = drinkSizeRepository;
    }

    @Override
    public Boolean isEmpty() {
        Long count = drinkSizeRepository.count();
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Drink_Size saveDrink_size(Drink_Size drink_Size) {
        return drinkSizeRepository.save(drink_Size);
    }

    @Override
    public List<Drink_Size> getAllDrinkSizes() {
        return drinkSizeRepository.findAll();
    }

    @Override
    public Drink_Size getSizeById(Integer id) {
        return drinkSizeRepository.findById(id).get();
    }

    
}
