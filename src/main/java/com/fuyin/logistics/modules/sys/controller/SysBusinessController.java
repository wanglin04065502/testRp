package com.fuyin.logistics.modules.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuyin.logistics.common.annotation.SysLog;
import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.modules.sys.entity.SysBusinessEntity;
import com.fuyin.logistics.modules.sys.service.SysBusinessService;

/**
 * 商户
 */
@RestController
@RequestMapping("/sys/business")
public class SysBusinessController extends AbstractController {

    @Autowired
    private SysBusinessService sysBusinessService;

    /**
     * 商户列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public Page<SysBusinessEntity> list(@RequestBody Map<String, Object> params) {
        return sysBusinessService.listBusiness(params);
    }

    /**
     * 商户新增
     * @param business
     * @return
     */
    @SysLog("新增商户")
    @RequestMapping("/save")
    public R save(@RequestBody SysBusinessEntity business) {
        return sysBusinessService.saveBusiness(business);
    }

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    @RequestMapping("/info")
    public R getById(@RequestBody Long id) {
        return sysBusinessService.getBusinessById(id);
    }

    /**
     * 商户修改
     * @param business
     * @return
     */
    @SysLog("修改商户")
    @RequestMapping("/update")
    public R update(@RequestBody SysBusinessEntity business) {
        return sysBusinessService.updateBusiness(business);
    }

    /**
     * 商户删除
     * @param id
     * @return
     */
    @SysLog("删除商户")
    @RequestMapping("/remove")
    public R batchRemove(@RequestBody Long[] id) {
        return sysBusinessService.batchRemove(id);
    }

}
