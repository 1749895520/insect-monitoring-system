package com.ruoyi.system.service.impl;

import com.ruoyi.system.entity.Files;
import com.ruoyi.system.mapper.FileMapper;
import com.ruoyi.system.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 邹永靖
 * @since 2022-07-21
 */
@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public Files getOne(String md5) {
        return fileMapper.getOne(md5);
    }

    @Override
    public void saveOrUpdate(Files saveFile) {
        fileMapper.saveOrUpdate(saveFile);
    }

    @Override
    public List<Files> getList() {
        return fileMapper.getList();
    }
}
