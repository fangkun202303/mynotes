package com.moduls.mynotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MynotesApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MynotesApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意的Application是启动类，就是main方法所属的类
        return builder.sources(MynotesApplication.class);
    }
}
