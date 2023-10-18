package com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.GymClub;
import com.example.demo.entity.User;
import com.example.demo.entity.enums.SexEnum;
import com.example.demo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.service.GymClubService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private GymClubService gymClubService;

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

    @Test
    public void insertTenGymClubs() {
        for (int i = 0; i < 10; i++) {
            GymClub gymClub = new GymClub();
            gymClub.setName("Gym Club " + i);
            gymClub.setDescription("Description " + i);
            gymClub.setCountry("Country " + i);
            gymClub.setCity("City " + i);
            gymClub.setStreetAddress("Street Address " + i);
            gymClub.setPhone("Phone " + i);
            gymClub.setBusinessHours("Business Hours " + i);
            gymClub.setAverageRating(BigDecimal.valueOf(4.5)); // 设置平均评分

            // 插入数据
            gymClubService.save(gymClub);
        }
    }

}
