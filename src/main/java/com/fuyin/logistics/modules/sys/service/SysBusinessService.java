package com.fuyin.logistics.modules.sys.service;

import java.util.Map;

import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.modules.sys.entity.SysBusinessEntity;

/**
 * 商户
 */
public interface SysBusinessService {

    /**
     * 分页查询商户列表
     * @param params
     * @return
     */
    Page<SysBusinessEntity> listBusiness(Map<String, Object> params);

    /**
     * 新增商户
     * @param Business
     * @return
     */
    R saveBusiness(SysBusinessEntity Business);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    R getBusinessById(Long id);

    /**
     * 修改商户
     * @param Business
     * @return
     */
    R updateBusiness(SysBusinessEntity Business);

    /**
     * 删除商户
     * @param id
     * @return
     */
    R batchRemove(Long[] id);

}
