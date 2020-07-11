package com.practice.miniprogram.checkin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@ComponentScan(basePackages = {"com.practice.miniprogram.checkin","com.practice.miniprogram.checkin.handle"})
@SpringBootApplication
@MapperScan(basePackages = {"com.practice.miniprogram.checkin.dao","com.practice.miniprogram.checkin.daoExtend"})
public class CheckinApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckinApplication.class, args);
    }

}
