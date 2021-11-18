package xyz.tanyongfeng.studentmannagersystem.service;

import org.springframework.stereotype.Service;
import xyz.tanyongfeng.studentmannagersystem.pojo.Teacher;

import java.util.List;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/

public interface TeacherService {

    Teacher insert(Teacher teacher);

    Boolean deleteTeacherById(Integer id);

    Boolean deleteTeacherByTeacherId(String teacherId);

    Teacher save(Teacher teacher);

    List<Teacher> getAll();

    Teacher getTeacherByTeacherId(String teacherId);


}
