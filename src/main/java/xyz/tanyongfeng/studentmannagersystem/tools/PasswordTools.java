package xyz.tanyongfeng.studentmannagersystem.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
public class PasswordTools {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }

//    new BCryptPasswordEncoder()
}