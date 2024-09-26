/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Studentmanager.reponsitory;

import com.Studentmanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Bạn có thể thêm phương thức tùy chỉnh nếu cần, ví dụ như findByEmail
    User findByEmail(String email);
}
