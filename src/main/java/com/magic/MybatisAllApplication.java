package com.magic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.magic.mapper")
@SpringBootApplication
@EnableCaching
public class MybatisAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisAllApplication.class, args);
    }

}
