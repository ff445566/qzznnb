package com.whx.qzznnb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@MapperScan({"com.whx.qzznnb.mapper","com.whx.qzznnb.*.mapper"})
@SpringBootApplication(scanBasePackages = {"com.whx.qzznnb"})
public class QzznnbApplication {

    public static void main(String[] args) {
        SpringApplication.run(QzznnbApplication.class, args);
    }
    @RequestMapping("/hello")
    public String hello(){
        return  " hello beijing 11 35 ";

    }

}
