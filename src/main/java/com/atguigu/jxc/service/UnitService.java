package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Unit;

import java.util.Map;

/**
 * @description
 */
public interface UnitService {

    ServiceVO save(Unit unit);

    ServiceVO delete(Integer unitId);

    Map<String,Object> list();
}
