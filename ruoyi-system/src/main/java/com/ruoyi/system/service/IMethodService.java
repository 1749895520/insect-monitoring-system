package com.ruoyi.system.service;

import com.ruoyi.system.entity.Method;

import java.util.List;


public interface IMethodService {

    List<Method> getList();

    void update(Method method);

    void insert(Method method);

    void delete(Integer id);
}
