package com.fuyin.logistics.modules.sys.service.impl;

import java.util.Map;

import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.Query;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.common.utils.CommonUtils;
import com.fuyin.logistics.modules.sys.dao.SysBusinessMapper;
import com.fuyin.logistics.modules.sys.entity.SysBusinessEntity;
import com.fuyin.logistics.modules.sys.service.SysBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商户
 */
@Service("SysBusinessService")
public class SysBusinessServiceImpl implements SysBusinessService {

    @Autowired
    private SysBusinessMapper sysBusinessMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public Page<SysBusinessEntity> listBusiness(Map<String, Object> params) {
        Query query = new Query(params);
        Page<SysBusinessEntity> page = new Page<>(query);
        sysBusinessMapper.listForPage(page, query);
        return page;
    }

    /**
     * 新增
     * @param business
     * @return
     */
    @Override
    public R saveBusiness(SysBusinessEntity business) {
        int count = sysBusinessMapper.save(business);
        return CommonUtils.msg(count);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public R getBusinessById(Long id) {
        SysBusinessEntity business = sysBusinessMapper.getObjectById(id);
        return CommonUtils.msg(business);
    }

    /**
     * 修改
     * @param business
     * @return
     */
    @Override
    public R updateBusiness(SysBusinessEntity business) {
        int count = sysBusinessMapper.update(business);
        return CommonUtils.msg(count);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public R batchRemove(Long[] id) {
        int count = sysBusinessMapper.batchRemove(id);
        return CommonUtils.msg(id, count);
    }

}
