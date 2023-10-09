package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectPage(IPage<User> page, Integer state);

}
