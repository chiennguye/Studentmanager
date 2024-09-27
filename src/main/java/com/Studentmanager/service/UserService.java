/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Studentmanager.service;

import com.Studentmanager.Model.User;
import com.Studentmanager.reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chienkoi
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        // Kiểm tra xem email đã tồn tại chưa trước khi lưu
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return " Email đã tồn tại !!!";
        }
        userRepository.save(user);
        return " Đăng ký thành công !!!";
    }

    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

}
