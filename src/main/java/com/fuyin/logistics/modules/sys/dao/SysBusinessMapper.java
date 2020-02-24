package com.fuyin.logistics.modules.sys.dao;

import com.fuyin.logistics.modules.sys.entity.SysBusinessEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商户
 */
@Mapper
public interface SysBusinessMapper extends BaseMapper<SysBusinessEntity> {
    /**
     * 查询所有商户
     * @param Id
     * @return
     */
    List<String> listBusiness(Long Id);
}
