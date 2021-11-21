package xyz.tanyongfeng.studentmannagersystem.service;

import xyz.tanyongfeng.studentmannagersystem.pojo.Score;

import java.util.List;

public interface ScoreService {

    Score save(Score score);

    List<Score> getScoreByStudentId(String studentId);

    List<Score> getAllScore();

    List<Score> getScoreByExample(Score score);

    List<Score> getScoreByStudentIdAndLessonInfo(String lessonId);

    void deleteByStudentId(String studentId);

    void deleteById(Integer studentId);

    void updateScore(Score score);
}
