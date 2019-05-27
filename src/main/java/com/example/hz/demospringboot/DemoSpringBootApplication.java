package com.example.hz.demospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Mybatis 扫描包
 */
//@MapperScan("com.example.hz.demospringboot.mapper")

/**
 * 定时类
 */
@SpringBootApplication
@EnableScheduling
@EnableEurekaServer
public class DemoSpringBootApplication{


    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }

}
