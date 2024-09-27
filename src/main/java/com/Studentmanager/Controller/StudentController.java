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
@RequestMapping(value = "/StudentManager")
public class StudentController {

    @GetMapping("/index.html")

    public String index() {
        return "StudentManager/index";
    }

}
