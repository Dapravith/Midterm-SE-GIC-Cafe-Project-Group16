package gic.i4c.GicCafe.info;

import java.util.List;

import gic.i4c.GicCafe.model.Addons;
import gic.i4c.GicCafe.model.Current_product_order;
import gic.i4c.GicCafe.model.Product;
import gic.i4c.GicCafe.model.Product_Size;

public class OrderInformation {
    private List<Addons> addonsList;
    private Product drink;
    private Product_Size size;
    private Current_product_order drink_order;
    private Float orderPrice;

    public OrderInformation(List<Addons> addonsList, Product drink, Product_Size size, Current_product_order drink_order) {
        this.addonsList = addonsList;
        this.drink = drink;
        this.size = size;
        this.drink_order = drink_order;
    } 

    public OrderInformation(Product drink, Product_Size size, Current_product_order drink_order) {
        this.drink = drink;
        this.size = size;
        this.drink_order = drink_order;
    }    
    

    public OrderInformation(Product drink, Product_Size size) {
        this.drink = drink;
        this.size = size;
    }

    public List<Addons> getAddonsList() {
        return this.addonsList;
    }

    public void setAddonsList(List<Addons> addonsList) {
        this.addonsList = addonsList;
    }

    public Product getDrink() {
        return this.drink;
    }

    public void setDrink(Product drink) {
        this.drink = drink;
    }

    public Product_Size getSize() {
        return this.size;
    }

    public void setSize(Product_Size size) {
        this.size = size;
    }

    public Current_product_order getDrink_order() {
        return this.drink_order;
    }

    public void setDrink_order(Current_product_order drink_order) {
        this.drink_order = drink_order;
    }

    public Float getOrderPrice() {
        orderPrice = drink.getPrice() + size.getPrice();
        return orderPrice;
    }
}