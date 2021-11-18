package xyz.tanyongfeng.studentmannagersystem.service.impl;

import org.springframework.stereotype.Service;
import xyz.tanyongfeng.studentmannagersystem.mapper.StudentMapper;
import xyz.tanyongfeng.studentmannagersystem.pojo.Student;
import xyz.tanyongfeng.studentmannagersystem.service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.findAll();
//        return null;
    }

    @Override
    public Student saveStudent(Student student) {
      return studentMapper.save(student);
    }

    @Override
    public boolean deleteByStudentId(String studentId) {
        studentMapper.deleteByStudentId(studentId);
        return true;
    }

    @Override
    public Student findById(String studentId) {
        return studentMapper.findByStudentId(studentId);
//        return null;
    }
}
