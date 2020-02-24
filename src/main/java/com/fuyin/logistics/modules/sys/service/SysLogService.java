package com.fuyin.logistics.modules.sys.service;

import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.modules.sys.entity.SysLogEntity;

import java.util.Map;

/**
 * 系统日志
 */
public interface SysLogService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    Page<SysLogEntity> listLog(Map<String, Object> params);

    /**
     * 批量删除
     * @param id
     * @return
     */
    R batchRemove(Long[] id);

    /**
     * 清空日志
     * @return
     */
    R batchRemoveAll();

}
