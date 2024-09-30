package com.Studentmanager.Controller;

import com.Studentmanager.Model.User;
import com.Studentmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/StudentManager")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/index.html")
    public String showIndexPage() {
        return "StudentManager/index"; // Trả về view index
    }

    // Hiển thị form đăng ký
    @GetMapping("/register.html")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "StudentManager/register"; // Trả về view đăng ký
    }

    // Xử lý đăng ký
    @PostMapping("/register.html")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            // Nếu có lỗi validation, trả lại trang đăng ký cùng với thông báo lỗi
            return "StudentManager/register";
        }

        String message = userService.register(user);
        model.addAttribute("message", message); // Đưa thông báo vào model để hiển thị
        return "StudentManager/register"; // Trả về view đăng ký cùng với thông điệp
    }

    // Hiển thị form đăng nhập
    @GetMapping("/login.html")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "StudentManager/login"; // Trả về view đăng nhập
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findByEmail(email);

        if (user != null && userService.checkLogin(password, user.getPassword())) {
            return "redirect:/HomePage.html"; // Chuyển đến trang chủ nếu đăng nhập thành công
        } else {
            return "error"; // Đăng nhập thất bại
        }
    }

    @GetMapping("/HomePage.html")
    public String home() {
        return "StudentManager/HomePage"; // Trả về trang home.html
    }
}
