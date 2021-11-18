package xyz.tanyongfeng.studentmannagersystem.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import xyz.tanyongfeng.studentmannagersystem.model.RestResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
public class ResponseUtil {
    public static <T> void restResponse(HttpServletResponse resp, HttpStatus status, RestResult<T> responseVo) throws IOException {
        resp.setStatus(status.value());
        resp.setContentType(MediaType.APPLICATION_JSON.toString());
        resp.getOutputStream().write(new ObjectMapper().writeValueAsBytes(responseVo));
    }
}