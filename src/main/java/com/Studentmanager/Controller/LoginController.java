package com.Studentmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Studentmanager.service.UserService;

@Controller
@RequestMapping(value = "StudentManager")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login.html")
    public String login() {
        return "StudentManager/login"; // Trả về trang login.html
    }

    @PostMapping("/login.html")
    public String loginPost(@RequestParam String email, @RequestParam String password, Model model) {
        if (userService.login(email, password)) {
            return "redirect:/StudentManager/HomePage.html"; // Chuyển hướng đến trang home nếu đăng nhập thành công
        }
        model.addAttribute("error", "Login not success!!");
        return "StudentManager/login"; // Quay lại trang login nếu thất bại
    }

    @GetMapping("/HomePage.html")
    public String home() {
        return "StudentManager/HomePage.html"; // Trả về trang home.html
    }

}
