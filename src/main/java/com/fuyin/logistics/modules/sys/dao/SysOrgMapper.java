package com.fuyin.logistics.modules.sys.dao;

import com.fuyin.logistics.modules.sys.entity.SysOrgEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 组织架构
 */
@Mapper
public interface SysOrgMapper extends BaseMapper<SysOrgEntity> {

	/**
	 * 统计子机构数量
	 * @param parentId
	 * @return
	 */
	int countOrgChildren(Long parentId);

	/**
	 * 查询子机构集合
	 * @param parentId
	 * @return
	 */
	List<Long> listOrgChildren(Long parentId);
	
}
