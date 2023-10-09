package com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.entity.enums.SexEnum;
import com.example.demo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }


    /**
     * user数据库insert测试
     *
     * */
    @Test
    void sqlTest(){

        for (int i = 2; i < 20; i++) {
            User user = new User();
            user.setAge(22+i);
            user.setName("小明");
            user.setTele("1234567891"+i);
            user.setAddress("湖南省");
            user.setSex(SexEnum.Male);
            userMapper.insert(user);
        }
    }

    @Test
    void test02(){
        Page<User> page =new Page<>(2,3);
        Page<User> userPage = userMapper.selectPage(page, Wrappers.<User>lambdaQuery().ge(User::getAge, 18));
        System.out.println(userPage.getCurrent());
    }

}
