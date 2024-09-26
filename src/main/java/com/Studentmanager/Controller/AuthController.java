/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Studentmanager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chienkoi
 */
@Controller
@RequestMapping(value = "/LandingPage")
public class AuthController {
    
        @GetMapping("/login.html")
    public String showLoginPage() {
        return "Landingpage/login"; // Trả về trang login.html
    }
        @GetMapping("/register.html")
    public String showRigisterPage() {
        return "Landingpage/register"; // Trả về trang login.html
    }    
        @GetMapping("/Forgetpassword.html")
    public String forgetpassword() {
        return "Landingpage/Forgetpassword"; // Trả về trang login.html
    }    
    @GetMapping("/Entercode.html")
    public String Entercode() {
        return "Landingpage/Entercode"; // Trả về trang login.html
    }  
        @GetMapping("/Newpassword.html")
    public String Newpassword() {
        return "Landingpage/Newpassword"; // Trả về trang login.html
    }
}
