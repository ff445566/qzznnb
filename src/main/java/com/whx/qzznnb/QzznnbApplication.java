package com.whx.qzznnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QzznnbApplication {

    public static void main(String[] args) {
        SpringApplication.run(QzznnbApplication.class, args);
    }
    @RequestMapping("/hello")
    public String hello(){
        return  "hello beijing ";

    }

}