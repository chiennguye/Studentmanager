/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Studentmanager.Controller;

import com.Studentmanager.Model.User;
import com.Studentmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chienkoi
 */
@Controller
@RequestMapping(value = "/LandingPage")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register.html")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "LandingPage/register"; // Trả về view đăng ký
    }

    @PostMapping("/register.html")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        String message = userService.registerUser(user);
        model.addAttribute("message", message); // Đưa thông báo vào model để hiển thị
        return "LandingPage/register"; // Trả về view đăng ký cùng với thông điệp
    }
}
