package com.fuyin.logistics.modules.sys.service.impl;

import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.Query;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.common.utils.CommonUtils;
import com.fuyin.logistics.modules.sys.dao.SysLogMapper;
import com.fuyin.logistics.modules.sys.entity.SysLogEntity;
import com.fuyin.logistics.modules.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 系统日志
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public Page<SysLogEntity> listLog(Map<String, Object> params) {
        Query query = new Query(params);
        Page<SysLogEntity> page = new Page<>(query);
        sysLogMapper.listForPage(page, query);
        return page;
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @Override
    public R batchRemove(Long[] id) {
        int count = sysLogMapper.batchRemove(id);
        return CommonUtils.msg(id, count);
    }

    /**
     * 清空
     * @return
     */
    @Override
    public R batchRemoveAll() {
        int count = sysLogMapper.batchRemoveAll();
        return CommonUtils.msg(count);
    }

}
