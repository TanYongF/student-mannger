package xyz.tanyongfeng.studentmannagersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
@Entity
@Data
@Table(indexes = {
        @Index(columnList = "teacherId", unique = true)
})
public class Teacher{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String teacherId;

    private String tel;

    private String password;

    private String email;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;


}
