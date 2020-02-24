package com.fuyin.logistics.modules.sys.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.Query;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.common.utils.CommonUtils;
import com.fuyin.logistics.modules.sys.entity.SysRestaurantEntity;
import com.fuyin.logistics.modules.sys.dao.SysRestaurantMapper;
import com.fuyin.logistics.modules.sys.service.SysRestaurantService;

/**
 * 商户管理
 */
@Service("sysRestaurantService")
public class SysRestaurantServiceImpl implements SysRestaurantService {

	@Autowired
    private SysRestaurantMapper sysRestaurantMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<SysRestaurantEntity> listSysRestaurant(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysRestaurantEntity> page = new Page<>(query);
		sysRestaurantMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param sysRestaurant
     * @return
     */
	@Override
	public R saveSysRestaurant(SysRestaurantEntity sysRestaurant) {
		int count = sysRestaurantMapper.save(sysRestaurant);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getSysRestaurantById(Long id) {
		SysRestaurantEntity sysRestaurant = sysRestaurantMapper.getObjectById(id);
		return CommonUtils.msg(sysRestaurant);
	}

    /**
     * 修改
     * @param sysRestaurant
     * @return
     */
	@Override
	public R updateSysRestaurant(SysRestaurantEntity sysRestaurant) {
		int count = sysRestaurantMapper.update(sysRestaurant);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = sysRestaurantMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
