package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * @description
 */
public interface SupplierService {


    Map<String,Object> list(Integer page, Integer rows, String supplierName);

    ServiceVO save(Supplier supplier);

    ServiceVO delete(String ids);

    List<Supplier> getComboboxList(String q);
}
