package xyz.tanyongfeng.studentmannagersystem.service;

import org.springframework.stereotype.Service;
import xyz.tanyongfeng.studentmannagersystem.pojo.Student;

import java.util.List;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
public interface StudentService {
    List<Student> getAllStudent();

    Student saveStudent(Student student);

    boolean deleteByStudentId(String studentId);

    Student findById(String studentId);



}
