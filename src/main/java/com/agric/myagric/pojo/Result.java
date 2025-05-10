package com.agric.myagric.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//统一响应结果
@NoArgsConstructor
@AllArgsConstructor
@Data //这个很重要，解决401问题 No acceptable representation
public class Result<T> {
    private Integer code;//业务状态码 0-成功 1-失败
    private String message;//提示信息
    private T data;//响应数据

    // 将 Result 对象转换为 ResponseEntity 对象，并设置正确的 Content-Type
    public ResponseEntity<Result<T>> toResponseEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(this, headers, HttpStatus.OK);
    }

    //快速返回频作成功响应结果(带响应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(0,"操作成功",data);
    }

    //快速返回操作成功响应结果
    public static Result success() {
        return new Result(0,"操作成功",null);
    }
    public static Result error(String message) {
        return new Result(1,message,null);
    }
}
