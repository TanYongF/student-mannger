package xyz.tanyongfeng.studentmannagersystem.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import xyz.tanyongfeng.studentmannagersystem.pojo.Score;

import java.util.List;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/21
 **/
public interface ScoreMapper extends JpaRepository<Score, Long> {

    List<Score> findByStudentId(String studentId);

    List<Score> findByLessonId(String lessonId);

    List<Score> findByLessonName(String lessonName);

    @Modifying
    @Transactional
    void deleteByStudentId(String student);
    @Modifying
    @Transactional
    void deleteById(Long integer);

}
