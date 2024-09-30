/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Studentmanager.reponsitory;

import com.Studentmanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@SuppressWarnings("unused")
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
