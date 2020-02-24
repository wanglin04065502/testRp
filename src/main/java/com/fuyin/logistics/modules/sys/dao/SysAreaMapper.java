package com.fuyin.logistics.modules.sys.dao;

import com.fuyin.logistics.modules.sys.entity.SysAreaEntity;
import com.fuyin.logistics.common.entity.Query;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 行政区域
 */
@Mapper
public interface SysAreaMapper extends BaseMapper<SysAreaEntity> {

	/**
	 * 根据父计编码查询
	 * @param query
	 * @return
	 */
	List<SysAreaEntity> listAreaByParentCode(Query query);

	/**
	 * 子节点总数
	 * @param areaId
	 * @return
	 */
	int countAreaChildren(Long areaId);
	
}
