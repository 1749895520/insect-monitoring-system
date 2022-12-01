package com.ruoyi.system.service.impl;

import com.ruoyi.system.entity.Method;
import com.ruoyi.system.mapper.MethodMapper;
import com.ruoyi.system.service.IMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodServiceImpl implements IMethodService {

    @Autowired
    private MethodMapper methodMapper;

    @Override
    public List<Method> getList() {
        return methodMapper.getList();
    }

    @Override
    public void update(Method method) {
        methodMapper.update(method);
    }

    @Override
    public void insert(Method method) {
        methodMapper.insert(method);
    }

    @Override
    public void delete(Integer id) {
        methodMapper.delete(id);
    }
}
