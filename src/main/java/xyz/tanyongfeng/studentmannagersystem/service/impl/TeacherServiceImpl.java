package xyz.tanyongfeng.studentmannagersystem.service.impl;

import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.tanyongfeng.studentmannagersystem.mapper.TeacherMapper;
import xyz.tanyongfeng.studentmannagersystem.model.TeacherDetail;
import xyz.tanyongfeng.studentmannagersystem.pojo.Teacher;
import xyz.tanyongfeng.studentmannagersystem.service.TeacherService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
@Service
public class TeacherServiceImpl implements TeacherService, UserDetailsService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Teacher teacher = new Teacher();
        teacher.setName(s);
        Example<Teacher> teacherExample = Example.of(teacher);
        Optional<Teacher> resultTeacher = teacherMapper.findOne(teacherExample);
        if(resultTeacher.isPresent()){
            return new TeacherDetail(resultTeacher.get());
        }
        return null;
    }



    @Override
    public Teacher insert(Teacher teacher) {
        return teacherMapper.save(teacher);
    }

    @Override
    public Boolean deleteTeacherById(Integer id) {
        teacherMapper.deleteById(id);
        return true;
    }

    @Override
    public Boolean deleteTeacherByTeacherId(String teacherId) {
        teacherMapper.deleteByTeacherId(teacherId);
        return true;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherMapper.save(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherMapper.findAll();
    }

    @Override
    public Teacher getTeacherByTeacherId(String teacherId) {
        return teacherMapper.findByTeacherId(teacherId);
    }
}
