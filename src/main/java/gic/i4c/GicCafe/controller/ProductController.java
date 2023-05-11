package gic.i4c.GicCafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;

import gic.i4c.GicCafe.info.OrderInformation;
import gic.i4c.GicCafe.model.Current_product_order;
import gic.i4c.GicCafe.model.Product;
import gic.i4c.GicCafe.model.Product_category;
import gic.i4c.GicCafe.model.Product_order;
import gic.i4c.GicCafe.service.AddonsService;
import gic.i4c.GicCafe.service.CategoryService;
import gic.i4c.GicCafe.service.CurrentProductOrderService;
import gic.i4c.GicCafe.service.ProductOrderService;
import gic.i4c.GicCafe.service.ProductService;
import gic.i4c.GicCafe.service.ProductSizeService;


@RestController
public class ProductController {
    private ProductService drinkService;
    private CategoryService categoryService;
    private AddonsService addonsService;
    private ProductSizeService drinkSizeService;
    private ProductOrderService drinkOrderService;
    private CurrentProductOrderService currentDrinkOrderService;

    public ProductController(ProductService drinkService, CategoryService categoryService, AddonsService addonsService, ProductSizeService drinkSizeService, ProductOrderService drinkOrderService, CurrentProductOrderService currentDrinkOrderService) {
        super();
        this.drinkService = drinkService;
        this.categoryService = categoryService;
        this.addonsService = addonsService;
        this.drinkSizeService = drinkSizeService;
        this.drinkOrderService = drinkOrderService;
        this.currentDrinkOrderService = currentDrinkOrderService;
    }

    @PostMapping("/new_drink")
    public String saveDrink(@ModelAttribute("drink") Product drink, @RequestParam("file") MultipartFile file){
        drinkService.saveProduct(drink, file);
        return "redirect:/new_drink";
    }

    @GetMapping("/list_drink")
    public String showDrinks(Model model){
        Current_product_order newOrder = new Current_product_order();
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("drinks", drinkService.getAllProducts());
        model.addAttribute("sugars", addonsService.getSugar());
        model.addAttribute("cream", addonsService.getCream());
        model.addAttribute("sizes", drinkSizeService.getAllProductSizes());
        model.addAttribute("order", newOrder);
        List<OrderInformation>orderInfos = new ArrayList<OrderInformation>();
        for (Current_product_order order : currentDrinkOrderService.getAllOrders()){
            orderInfos.add(new OrderInformation(drinkService.getProductById(order.getProduct_id()), drinkSizeService.getSizeById(order.getSize_id()), currentDrinkOrderService.getOrderById(order.getId())));
        }
        model.addAttribute("allOrders", orderInfos);
        return "drinkSelection";
    }

    @GetMapping("/drink_management")
    public String listDrink (Model model) {
        model.addAttribute("drinks", drinkService.getAllDrinks());
        return "drinkManagement";
    }

    @GetMapping("/food_management")
    public String listFood (Model model) {
        model.addAttribute("drinks", drinkService.getAllFoods());
        return "foodManagement";
    }

    

    @GetMapping("/drink_management/edit/{id}")
    public String editDrink(@PathVariable Integer id, Model model){
        Product updateDrink = drinkService.getProductById(id);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("drink", updateDrink);
        return "editDrink";
    }

    @PostMapping("/drink_management/{id}")
    public String updateDrink (@PathVariable Integer id, @ModelAttribute("drink") Product updatedDrink, Model model, @RequestParam("file") MultipartFile file){
        Product drink = drinkService.getProductById(id);
        drink.setId(id);
        drink.setCode(updatedDrink.getCode());
        drink.setName(updatedDrink.getName());
        drink.setCategory_id(updatedDrink.getCategory_id());
        drink.setPrice(updatedDrink.getPrice());
        drink.setNote(updatedDrink.getNote());
        drinkService.saveProduct(drink, file);
        return "redirect:/drink_management";
    }

    @GetMapping("/drink_management/delete/{id}")
    public String deleteDrink (@PathVariable Integer id) {
        drinkService.deleteProduct(id);
        return "redirect:/drink_management";
    }

    @GetMapping("/drink_management/{id}")
    public String showDrink(@PathVariable Integer id, Model model){
        Product selectDrink = drinkService.getProductById(id);
        Product_category category = categoryService.getCategoryById(selectDrink.getCategory_id());
        model.addAttribute("drinks", drinkService.getAllDrinks());
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedDrink", selectDrink);
        return "viewDrink";
    }

    @GetMapping("/food_management/{id}")
    public String showFood(@PathVariable Integer id, Model model){
        Product selectDrink = drinkService.getProductById(id);
        Product_category category = categoryService.getCategoryById(selectDrink.getCategory_id());
        model.addAttribute("drinks", drinkService.getAllFoods());
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedDrink", selectDrink);
        return "viewFood";
    }

}
