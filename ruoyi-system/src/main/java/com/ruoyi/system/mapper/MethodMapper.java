package com.ruoyi.system.mapper;

import com.ruoyi.system.entity.Method;

import java.util.List;

public interface MethodMapper {

    List<Method> getList();

    void update(Method method);

    void insert(Method method);

    void delete(Integer id);
}
