package com.fms;

import com.fms.controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("com.fms.mapper")
public class SpingbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingbootApplication.class, args);

    }



}
