package xyz.tanyongfeng.studentmannagersystem.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
@Entity
@Table(indexes = {
        @Index(columnList = "studentId", unique = true)
})
@Data
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String studentId;

    private String name;

    private String professional;

    private String qq;

    private boolean gender;

    private String tel;

}
