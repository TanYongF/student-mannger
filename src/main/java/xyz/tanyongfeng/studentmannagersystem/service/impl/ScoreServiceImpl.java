package xyz.tanyongfeng.studentmannagersystem.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import xyz.tanyongfeng.studentmannagersystem.mapper.ScoreMapper;
import xyz.tanyongfeng.studentmannagersystem.pojo.Score;
import xyz.tanyongfeng.studentmannagersystem.service.ScoreService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/21
 **/
@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public Score save(Score score) {
        return scoreMapper.save(score);
    }

    @Override
    public List<Score> getScoreByStudentId(String studentId) {
        return scoreMapper.findByStudentId(studentId);
    }

    @Override
    public List<Score> getAllScore() {
        return scoreMapper.findAll();
    }

    @Override
    public List<Score> getScoreByExample(Score score) {
        Example<Score> example = Example.of(score);
        return scoreMapper.findAll(example);
    }

    @Override
    public List<Score> getScoreByStudentIdAndLessonInfo(String lessonId) {
        return scoreMapper.findByLessonId(lessonId);
    }

    @Override
    public void deleteByStudentId(String studentId) {
         scoreMapper.deleteByStudentId(studentId);
    }

    public void deleteById(Integer id) {
        scoreMapper.deleteById(Integer.toUnsignedLong(id));
    }

    @Override
    public void updateScore(Score score) {
//        scoreMapper.findById()
        Optional<Score> old = scoreMapper.findById(score.getId());
//        BeanUtils.co


    }
}
