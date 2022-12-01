package com.ruoyi.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.entity.Files;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 邹永靖
 * @since 2022-07-21
 */
public interface FileMapper extends BaseMapper<Files> {

    Files getOne(String md5);

    void saveOrUpdate(Files saveFile);

    List<Files> getList();
}
