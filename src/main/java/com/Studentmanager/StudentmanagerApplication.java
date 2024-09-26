package com.Studentmanager;

import com.Studentmanager.Model.User;
import com.Studentmanager.reponsitory.UserRepository;
import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentmanagerApplication implements CommandLineRunner{
    
        @Autowired
    private DataSource dataSource;
            @Autowired
    private UserRepository userRepository; // Inject UserRepository

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagerApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // Kiểm tra kết nối
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                System.out.println("Kết nối đến MySQL thành công!");
            } else {
                System.out.println("Không thể kết nối đến MySQL.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi kết nối MySQL: " + e.getMessage());
        }

         // Lấy tất cả người dùng từ cơ sở dữ liệu
        List<User> users = userRepository.findAll();

        // Kiểm tra và in ra danh sách người dùng
        if (users.isEmpty()) {
            System.out.println("Không có người dùng nào trong cơ sở dữ liệu.");
        } else {
            System.out.println("Danh sách người dùng:");
            users.forEach(user -> System.out.println(user));
        }
    }

}
