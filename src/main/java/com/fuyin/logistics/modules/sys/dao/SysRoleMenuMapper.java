package com.fuyin.logistics.modules.sys.dao;

import java.util.List;

import com.fuyin.logistics.modules.sys.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色与菜单关系
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

	/**
	 * 根据菜单id批量删除
	 * @param id
	 * @return
	 */
	int batchRemoveByMenuId(Long[] id);

	/**
	 * 根据角色id批量删除
	 * @param id
	 * @return
	 */
	int batchRemoveByRoleId(Long[] id);

	/**
	 * 查询角色所有菜单id集合
	 * @param id
	 * @return
	 */
	List<Long> listMenuId(Long id);
	
}
