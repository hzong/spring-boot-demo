package com.example.hz.demospringboot.controller;

import com.example.hz.demospringboot.entity.hzim.Users;
import com.example.hz.demospringboot.entity.sys.SysConfig;
import com.example.hz.demospringboot.mapper.hzim.UsersMapper;
import com.example.hz.demospringboot.mapper.sys.SysConfigMapper;
import com.example.hz.demospringboot.pojo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2019-03-03 16:51
 * @Created by hzong
 * localhost:8080/v2/hello
 */
@RestController
public class HelloController {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    UsersMapper usersMapper;
    @Autowired
    SysConfigMapper sysConfigMapper;


    @RequestMapping("/v1/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/v2/hello")
    public User hello2() {
        User user = new User();
        user.setPassword("123");
        user.setUsername("222");
        return user;
    }

    @RequestMapping("/v1/getUser")
    public Users getUser(String userId){
        return usersMapper.selectByPrimaryKey(userId);
    }

    @RequestMapping("/v1/getSysConfig")
    public SysConfig getSys(String variable){
        return sysConfigMapper.selectByPrimaryKey(variable);
    }

}
