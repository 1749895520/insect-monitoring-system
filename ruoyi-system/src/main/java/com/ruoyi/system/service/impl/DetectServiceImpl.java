package com.ruoyi.system.service.impl;

import com.ruoyi.system.entity.Detect;
import com.ruoyi.system.mapper.DetectMapper;
import com.ruoyi.system.service.IDetectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetectServiceImpl implements IDetectService {
    @Autowired
    private DetectMapper detectMapper;

    @Override
    public List<Detect> getList() {
        return detectMapper.getList();
    }
}
