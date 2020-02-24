package com.fuyin.logistics.modules.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuyin.logistics.common.annotation.SysLog;
import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.modules.sys.entity.SysRestaurantEntity;
import com.fuyin.logistics.modules.sys.service.SysRestaurantService;

/**
 * 商户管理
 */
@RestController
@RequestMapping("/sys/restaurant")
public class SysRestaurantController extends AbstractController {
	
	@Autowired
	private SysRestaurantService sysRestaurantService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysRestaurantEntity> list(@RequestBody Map<String, Object> params) {
		return sysRestaurantService.listSysRestaurant(params);
	}
		
	/**
	 * 新增
	 * @param sysRestaurant
	 * @return
	 */
	@SysLog("新增商户")
	@RequestMapping("/save")
	public R save(@RequestBody SysRestaurantEntity sysRestaurant) {
		return sysRestaurantService.saveSysRestaurant(sysRestaurant);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return sysRestaurantService.getSysRestaurantById(id);
	}
	
	/**
	 * 修改
	 * @param sysRestaurant
	 * @return
	 */
	@SysLog("修改商户")
	@RequestMapping("/update")
	public R update(@RequestBody SysRestaurantEntity sysRestaurant) {
		return sysRestaurantService.updateSysRestaurant(sysRestaurant);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除商户")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return sysRestaurantService.batchRemove(id);
	}
	
}
