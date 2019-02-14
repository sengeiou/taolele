package com.cjw.taolele;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.cjw.taolele.dao")
@SpringBootApplication
public class TaoleleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaoleleApplication.class, args);
    }

}

