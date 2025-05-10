package com.agric.myagric;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//启动类
@SpringBootApplication

@EnableScheduling
//@ComponentScan({"org.springblade","com.hello","com.test"})
@MapperScan({"com.agric.myagric.mapper"})
public class MyAgricApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyAgricApplication.class, args);
    }
}
