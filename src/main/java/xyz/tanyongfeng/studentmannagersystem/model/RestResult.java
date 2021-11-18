package xyz.tanyongfeng.studentmannagersystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
import xyz.tanyongfeng.studentmannagersystem.enums.ResultEnum;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> {

    private Integer code;
    private String message;
    private T data;
    private HttpStatus httpStatus;

    public RestResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public RestResult(HttpStatus status, T data){
        this.httpStatus = status;
        this.data = data;
    }

    public static <T> RestResult<T> success(Integer code, T data) {
        return new RestResult<>(code, data);
    }

    public static <T> RestResult<T> success(T data) {
        return new RestResult<>(200, data);
    }

    public static <T> RestResult<T> success(Integer code, String message) {
        return new RestResult<>(code, message);
    }

    public static <T> RestResult<T> success(ResultEnum resultEnum) {
        return new RestResult<>(resultEnum.getResultCode(), resultEnum.getResultMsg());
    }

    public static <T> RestResult<T> error(Integer code, String message) {
        return new RestResult<>(code, message);
    }

    public static <T> RestResult<T> error(Integer code, T data) {
        return new RestResult<>(code, data);
    }

    public static <T> RestResult<T> error(String message) {
        return new RestResult<>(500, message);
    }

    public static <T> RestResult<T> error(ResultEnum resultEnum) {
        return new RestResult<>(resultEnum.getResultCode(), resultEnum.getResultMsg());
    }
    public static <T> RestResult<T> success(HttpStatus status, T data){
        return new RestResult<>(status, data);
    }
}