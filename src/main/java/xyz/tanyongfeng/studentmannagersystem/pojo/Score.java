package xyz.tanyongfeng.studentmannagersystem.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Describe: 成绩类
 * @Author: tyf
 * @CreateTime: 2021/11/18
 **/
@Entity
@Data
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String studentId;

    private String lessonId;

    private String lessonName;

    private Integer score;
}
