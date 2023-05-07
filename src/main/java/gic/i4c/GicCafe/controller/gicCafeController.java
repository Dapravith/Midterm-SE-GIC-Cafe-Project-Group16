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
    
        @GetMapping(path = "/tableSelection")
        public ModelAndView tableSelection(){
            return new ModelAndView("tableSelection");
        }

        @GetMapping(path = "/signup")
        public ModelAndView signup(){
            return new ModelAndView("signup");
        }
    }