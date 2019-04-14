package com.example.hz.demospringboot;

import com.example.hz.demospringboot.entity.hzim.Users;
import com.example.hz.demospringboot.mapper.hzim.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Classname UserTest
 * @Description TODO
 * @Date 2019-03-06 00:00
 * @Created by hzong
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UsersMapper usersMapper;



    @Test
    public void insertTest(){
        Users user = new Users();
        user.setAppId(11L);
        user.setNick("许褚");
        user.setUserId("xuchu");
        user.setUpdateTime(new Date());
        usersMapper.insertSelective(user);
    }


}
