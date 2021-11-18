package xyz.tanyongfeng.studentmannagersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudentMannagerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMannagerSystemApplication.class, args);
    }

}
