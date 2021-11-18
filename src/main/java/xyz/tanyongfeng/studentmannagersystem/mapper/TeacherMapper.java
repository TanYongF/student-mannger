package xyz.tanyongfeng.studentmannagersystem.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.tanyongfeng.studentmannagersystem.pojo.Teacher;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
public interface TeacherMapper extends JpaRepository<Teacher,Integer>  {

    void deleteByTeacherId(String teacherId);

    Teacher findByTeacherId(String teacherId);

}
