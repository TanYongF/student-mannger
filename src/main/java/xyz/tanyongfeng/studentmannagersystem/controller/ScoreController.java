package xyz.tanyongfeng.studentmannagersystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.tanyongfeng.studentmannagersystem.model.RestResult;
import xyz.tanyongfeng.studentmannagersystem.pojo.Score;
import xyz.tanyongfeng.studentmannagersystem.pojo.Student;
import xyz.tanyongfeng.studentmannagersystem.service.ScoreService;
import xyz.tanyongfeng.studentmannagersystem.service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/17
 **/
@Controller
@RequestMapping("/score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;

    @Resource
    private StudentService studentService;

    @GetMapping("")
    public String scores(Model model,
                         @RequestParam(value = "studentId", required = false) String studentId,
                         @RequestParam(value = "lessonId", required = false) String lessonId){
        Score query = new Score();
        if(studentId != null) query.setStudentId(studentId);
        if(lessonId != null)query.setLessonId(lessonId);
        List<Score> scores = scoreService.getScoreByExample(query);
        model.addAttribute("scores", scores);
        return "score";
    }

    @PostMapping("")
    @ResponseBody
    public RestResult saveScore(@RequestBody Score score){
        Score save = scoreService.save(score);
        return RestResult.success(HttpStatus.OK, save);
    }

    @DeleteMapping("")
    @ResponseBody
    public RestResult<String> deleteByStudentId(@RequestParam(value = "studentId", required = true) String stuentId){
        scoreService.deleteByStudentId(stuentId);
        return RestResult.success(HttpStatus.ACCEPTED, "ok");
    }
    @ResponseBody
    @DeleteMapping("/{studentId}")
    public RestResult deleteById(@PathVariable Integer studentId){
        scoreService.deleteById(studentId);
        return RestResult.success(HttpStatus.OK, "ok");
    }

    @GetMapping("/{studentId}")
    public String getScore(@PathVariable String studentId,
                           Model model){
        Student ret = studentService.findById(studentId);
        List<Score> scores = scoreService.getScoreByStudentId(studentId);
        model.addAttribute("student", ret);
        model.addAttribute("scores", scores);
        return "userInfo";
    }

    @ResponseBody
    @PutMapping("")
    public String updateScore(@RequestBody Score score){
        return null;


    }


}
