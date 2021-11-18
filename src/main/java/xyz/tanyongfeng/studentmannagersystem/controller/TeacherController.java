package xyz.tanyongfeng.studentmannagersystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.tanyongfeng.studentmannagersystem.model.RestResult;
import xyz.tanyongfeng.studentmannagersystem.pojo.Student;
import xyz.tanyongfeng.studentmannagersystem.service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
@Controller
public class TeacherController {

    @Resource
    private StudentService studentService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }


}
