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
 * @CreateTime: 2021/11/17
 **/
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;


    @GetMapping("")
    public String getAllStudents(Model model){
        List<Student> ret = studentService.getAllStudent();
        model.addAttribute("students", ret);
//        return RestResult.success(HttpStatus.OK,ret);
        return "students";
    }


    @ResponseBody
    @GetMapping("/{studentId}")
    public RestResult<Student> getStudentById(@PathVariable String studentId){
        Student ret = studentService.findById(studentId);
        return RestResult.success(HttpStatus.OK, ret);
//        return null;
    }

    @ResponseBody
    @DeleteMapping("/{studentId}")
    public RestResult<Boolean> deleteStudentById(@PathVariable String studentId){
        boolean ret = studentService.deleteByStudentId(studentId);
        return RestResult.success(HttpStatus.OK, ret);
    }

    @ResponseBody
    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable String studentId){
        return null;
    }

    @ResponseBody
    @PostMapping("")
    public RestResult<Student> savaStudent(@RequestBody Student student){
        Student ret = studentService.saveStudent(student);
        return RestResult.success(HttpStatus.CREATED, ret);
    }


}
