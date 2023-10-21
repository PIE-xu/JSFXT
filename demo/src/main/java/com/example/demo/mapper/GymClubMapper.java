package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.GymClub;
import java.util.List;

public interface GymClubMapper extends BaseMapper<GymClub> {

    List<GymClub> selectPage(IPage<GymClub> page, Integer state);
}
