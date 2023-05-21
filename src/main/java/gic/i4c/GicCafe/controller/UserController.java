package gic.i4c.GicCafe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import gic.i4c.GicCafe.model.User;
import gic.i4c.GicCafe.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/userManagement/addCashier")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "AddUser";
    }

    @PostMapping("/user_management/save_user")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam("file") MultipartFile file,
            @RequestParam("dob") String dob) {
        user.setRole("user");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;

        try {
            date = formatter.parse(dob);
            user.setDate_of_birth(date);
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        userService.saveUser(user, file);
        return "redirect:/user_management";
    }

    @GetMapping("/userManagement")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userManagement";
    }

    @GetMapping("/user_management/{id}")
    public String showFood(@PathVariable Integer id, Model model) {
        User selectUser = userService.getUserById(id);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("selectedUser", selectUser);
        return "viewUser";
    }

    @GetMapping("/user_management/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "EditUser";
    }

    @PostMapping("/user_management/edit/save/{id}")
    public String saveEditUser(@PathVariable("id") Integer id, @ModelAttribute("user") User user,
            @RequestParam("file") MultipartFile file, @RequestParam("dob") String dob) {
        user.setRole("user");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;

        try {
            date = formatter.parse(dob);
            user.setDate_of_birth(date);
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        user.setId(id);
        userService.saveUser(user, file);
        return "redirect:/user_management";
    }

    @GetMapping("/user_management/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/user_management";
    }
}