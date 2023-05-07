package gic.i4c.GicCafe.info;

import java.util.List;

import gic.i4c.GicCafe.model.Addons;
import gic.i4c.GicCafe.model.Drink;
import gic.i4c.GicCafe.model.Drink_Order;
import gic.i4c.GicCafe.model.Drink_Size;

public class OrderInformation {
    private List<Addons> addonsList;
    private Drink drink;
    private Drink_Size size;
    private Drink_Order drink_order;

    public OrderInformation(List<Addons> addonsList, Drink drink, Drink_Size size, Drink_Order drink_Order) {
        this.addonsList = addonsList;
        this.drink = drink;
        this.size = size;
        this.drink_order = drink_Order;
    } 

    public OrderInformation(Drink drink, Drink_Size drink_Size, Drink_Order drink_order) {
        this.drink = drink;
        this.drink_order = drink_order;
    }    
    

    public OrderInformation(Drink drink, Drink_Size size) {
        this.drink = drink;
        this.size = size;
    }

    public List<Addons> getAddonsList() {
        return this.addonsList;
    }

    public void setAddonsList(List<Addons> addonsList) {
        this.addonsList = addonsList;
    }

    public Drink getDrink() {
        return this.drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Drink_Size getSize() {
        return this.size;
    }

    public void setSize(Drink_Size size) {
        this.size = size;
    }

    public Drink_Order getDrink_order() {
        return this.drink_order;
    }

    public void setDrink_order(Drink_Order drink_order) {
        this.drink_order = drink_order;
    }


}
