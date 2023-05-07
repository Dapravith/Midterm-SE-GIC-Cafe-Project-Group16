package gic.i4c.GicCafe.service;

import java.util.List;

import gic.i4c.GicCafe.model.Drink;
import gic.i4c.GicCafe.model.Drink_Size;

public interface DrinkSizeService {
    Boolean isEmpty();
    Drink_Size saveDrink_size(Drink_Size drink_size);
    List<Drink_Size> getAllDrinkSizes();
    Drink_Size getSizeById(Integer id);
}
