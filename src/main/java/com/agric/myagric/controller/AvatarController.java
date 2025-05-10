package com.agric.myagric.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/user/avatars")
public class AvatarController {

    @GetMapping("/{filename}")
    @ResponseBody
    public byte[] getAvatar(@PathVariable String filename) throws IOException {
        // 读取静态资源文件
        System.out.println("qqq"+filename);
        Resource resource = new ClassPathResource("/static/user/avatars/"+filename);
        // 将静态资源文件的内容转换为字节数组
        byte[] data = resource.getInputStream().readAllBytes();
        // 设置 Content-Type
        MediaType mediaType = MediaType.IMAGE_JPEG; // 设置为图片类型，根据实际情况调整
        if (filename.endsWith(".png")) {
            mediaType = MediaType.IMAGE_PNG;
        } else if (filename.endsWith(".gif")) {
            mediaType = MediaType.IMAGE_GIF;
        }

        // 设置返回的Content-Type
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        // 返回字节数组作为响应体
        return data;
    }
}

