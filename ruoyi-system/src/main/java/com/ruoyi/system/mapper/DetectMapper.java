package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.entity.Detect;

import java.util.List;

public interface DetectMapper extends BaseMapper<Detect> {


    List<Detect> getList();
}
