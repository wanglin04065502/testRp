package com.fuyin.logistics.modules.sys.dao;

import com.fuyin.logistics.modules.sys.entity.QuartzJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 */
@Mapper
public interface QuartzJobLogMapper extends BaseMapper<QuartzJobLogEntity> {

	/**
	 * 批量删除
	 * @return
	 */
	int batchRemoveAll();
	
}
