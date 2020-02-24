package com.fuyin.logistics.modules.sys.service.impl;

import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.Query;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.common.utils.CommonUtils;
import com.fuyin.logistics.modules.sys.dao.QuartzJobLogMapper;
import com.fuyin.logistics.modules.sys.entity.QuartzJobLogEntity;
import com.fuyin.logistics.modules.sys.service.QuartzJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 定时任务日志
 */
@Service("quartzJobLogService")
public class QuartzJobLogServiceImpl implements QuartzJobLogService {

	@Autowired
	private QuartzJobLogMapper quartzJobLogMapper;

	/**
	 * 分页查询任务日志
	 * @param params
	 * @return
	 */
	@Override
	public Page<QuartzJobLogEntity> listForPage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<QuartzJobLogEntity> page = new Page<>(query);
		quartzJobLogMapper.listForPage(page, query);
		return page;
	}

	/**
	 * 批量删除日志
	 * @param id
	 * @return
	 */
	@Override
	public R batchRemove(Long[] id) {
		int count = quartzJobLogMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	/**
	 * 清空日志
	 * @return
	 */
	@Override
	public R batchRemoveAll() {
		int count = quartzJobLogMapper.batchRemoveAll();
		return CommonUtils.msg(count);
	}


}
