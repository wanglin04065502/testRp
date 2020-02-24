package com.fuyin.logistics.modules.sys.service;

import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.modules.sys.entity.QuartzJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 */
public interface QuartzJobLogService {

	/**
	 * 分页查询任务日志
	 * @param params
	 * @return
	 */
	Page<QuartzJobLogEntity> listForPage(Map<String, Object> params);

	/**
	 * 批量删除日志
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
