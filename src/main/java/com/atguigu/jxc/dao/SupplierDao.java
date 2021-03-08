package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 供应商
 */
public interface SupplierDao {

    List<Supplier> getSupplierList(@Param("offSet") Integer offSet, @Param("pageRow") Integer pageRow, @Param("supplierName") String supplierName);

    Integer getSupplierCount(@Param("supplierName") String supplierName);

    Integer saveSupplier(Supplier supplier);

    Integer updateSupplier(Supplier supplier);

    Supplier getSupplierById(Integer supplierId);

    Integer deleteSupplier(Integer supplierId);


    List<Supplier> getComboboxList(@Param("q") String q);
}
