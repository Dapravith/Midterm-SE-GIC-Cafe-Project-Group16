package gic.i4c.GicCafe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


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

        @GetMapping(path = "/PopupDrink")
        public ModelAndView PopupDrink() {
            return new ModelAndView("PopupDrink");
        }

        @GetMapping(path = "/changCalculate")
        public ModelAndView changeCalculate() {
            return new ModelAndView("changeCalculate");
        }

        @GetMapping(path = "/Receipt")
        public ModelAndView Receipt() {
            return new ModelAndView("Receipt");
        }

        @GetMapping(path = "/CashierManagement")
        public ModelAndView CashierManagement() {
            return new ModelAndView("CashierManagement");
        }

        @GetMapping(path = "/drinkManagement")
        public ModelAndView drinkManagement() {
            return new ModelAndView("drinkManagement");
        }

        @GetMapping(path = "/foodManagement")
        public ModelAndView foodManagement() {
            return new ModelAndView("foodManagement");
        }

        @GetMapping(path = "/addCashier")
        public ModelAndView addCashier() {
            return new ModelAndView("addCashier");
        }


        @GetMapping(path = "/addDrink")
        public ModelAndView addDrink() {
            return new ModelAndView("addDrink");
        }

        @GetMapping(path = "/editDrink")
        public ModelAndView editDrink() {
            return new ModelAndView("editDrink");
        }

        @GetMapping(path = "/addCategories")
        public ModelAndView addCategories() {
            return new ModelAndView("addCategories");
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

        @GetMapping(path = "/viewDrink")
        public ModelAndView viewDrink() {
            return new ModelAndView("viewDrink");
        }

        @GetMapping(path = "/AdminHome")
        public ModelAndView AdminHome() {
            return new ModelAndView("AdminHome");
        }

        @GetMapping(path = "/viewFood")
        public ModelAndView viewFood() {
            return new ModelAndView("viewFood");
        }

        @GetMapping(path = "/viewCashiers")
        public ModelAndView viewUsers() {
            return new ModelAndView("viewUsers");
        }
}
