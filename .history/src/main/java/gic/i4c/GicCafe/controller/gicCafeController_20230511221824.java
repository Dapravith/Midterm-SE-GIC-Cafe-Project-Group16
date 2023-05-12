package gic.i4c.GicCafe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.Generated;




@RestController
    public class gicCafeController {
        @GetMapping(path = "/login")
        public ModelAndView login(){
            return new ModelAndView("login");
        }
        
        @GetMapping(path = "/signup")
        public ModelAndView signup(){
            return new ModelAndView("signup");
        }
    
        @GetMapping(path = "/tableSelection")
        public ModelAndView tableSelection(){
            return new ModelAndView("tableSelection");
        }


        @GetMapping(path = "/drinkSelection")
        public ModelAndView drinkSelection(){
            return new ModelAndView("drinkSelection");
        }

        @GetMapping(path = "/changeCalculate")
        public ModelAndView changeCalculate() {
            return new ModelAndView("changeCalculate");
        }

        @GetMapping(path = "/addCategories")
        public ModelAndView addCategories(){
            return new ModelAndView("addCategories");
        }
        
        
        @GetMapping(path = "/Receipt")
        public ModelAndView Receipt(){
            return new ModelAndView("Receipt");
        }

        @GetMapping(path = "/addNewDrink")
        public ModelAndView addNewDrink(){
            return new ModelAndView("addNewDrink");
        }

        @GetMapping(path = "/editDrink")
        public ModelAndView editDrink(){
            return new ModelAndView("editDrink");
        }

        @GetMapping("/TableManagement")
    public ModelAndView TableManagement() {
        ModelAndView mav = new ModelAndView("TableManagement");
        return mav;
        }

        @GetMapping(path = "/ProductManagement")
        public ModelAndView ProductManagement() {
            return new ModelAndView("ProductManagement");
        }

        @GetMapping(path = "/UserManagement")
        public ModelAndView UserManagement() {
            return new ModelAndView("UserManagement");
        }

        @GetMapping(path = "/cashierCrud")
        public ModelAndView cashierCrud() {
            return new ModelAndView("cashierCrud");
        } 
        
        @GetMapping(path = "/drinkManagement")
        public ModelAndView drinkManagement() {
            return new ModelAndView("drinkManagement");
        }

        @GetMapping(path = "/foodManagement")
        public ModelAndView foodManagement() {
            return new ModelAndView("foodManagement");
        }

        @GetMapping(path = "/viewDrink")
        public ModelAndView viewDrink() {
            return new ModelAndView("viewDrink");
        }

        @GetMapping(path = "/viewFood")
        public ModelAndView viewFood() {
            return new ModelAndView("viewFood");
        }
        
    
}
