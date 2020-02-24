package com.fuyin.logistics.modules.sys.service;

import java.util.Map;

import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.modules.sys.entity.SysRestaurantEntity;

/**
 * 商户管理
 */
public interface SysRestaurantService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<SysRestaurantEntity> listSysRestaurant(Map<String, Object> params);

    /**
     * 新增
     * @param sysRestaurant
     * @return
     */
	R saveSysRestaurant(SysRestaurantEntity sysRestaurant);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getSysRestaurantById(Long id);

    /**
     * 修改
     * @param sysRestaurant
     * @return
     */
	R updateSysRestaurant(SysRestaurantEntity sysRestaurant);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
