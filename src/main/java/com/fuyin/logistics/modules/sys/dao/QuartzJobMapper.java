package com.fuyin.logistics.modules.sys.dao;

import com.fuyin.logistics.modules.sys.entity.QuartzJobEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 定时任务
 */
@Mapper
public interface QuartzJobMapper extends BaseMapper<QuartzJobEntity> {

}
