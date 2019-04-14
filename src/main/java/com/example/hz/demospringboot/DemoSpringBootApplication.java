package com.example.hz.demospringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/**
 * Mybatis 扫描包
 */
//@MapperScan("com.example.hz.demospringboot.mapper")
/**
 * 定时类
 */
@EnableScheduling
@EnableEurekaServer
public class DemoSpringBootApplication<EnableEurekaServer> {


    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }

}
