package xyz.tanyongfeng.studentmannagersystem.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import xyz.tanyongfeng.studentmannagersystem.pojo.Student;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
public interface StudentMapper extends JpaRepository<Student, Integer> {

    Student findByStudentId(String studentId);

    @Modifying
    @Transactional
    void deleteByStudentId(String studentId);

    @Override
    void deleteById(Integer integer);
}
