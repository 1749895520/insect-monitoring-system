package com.ruoyi.system.service;

import com.ruoyi.system.entity.Files;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 邹永靖
 * @since 2022-07-21
 */
public interface IFileService {

    Files getOne(String md5);

    void saveOrUpdate(Files saveFile);

    List<Files> getList();
}
