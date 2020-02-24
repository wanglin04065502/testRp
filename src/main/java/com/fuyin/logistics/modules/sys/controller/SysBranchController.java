package com.fuyin.logistics.modules.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fuyin.logistics.common.annotation.SysLog;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.modules.sys.entity.SysBranchEntity;
import com.fuyin.logistics.modules.sys.service.SysBranchService;

/**
 * 机构
 */
@RestController
@RequestMapping("/sys/branch")
public class SysBranchController extends AbstractController {

    @Autowired
    private SysBranchService sysBranchService;

    /**
     * 根据上级dept查询子节点，子机构列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public R list(@RequestBody Map<String, Object> params) {
        return sysBranchService.listBranchByDept(params);
    }

    /**
     * 根据上级dept查询子节点，树形目录
     * @return
     */
    @RequestMapping("/select")
    public List<SysBranchEntity> select(@RequestParam String id) {
        return sysBranchService.listBranchByDept(id);
    }

    /**
     * 新增机构
     * @param branch
     * @return
     */
    @SysLog("新增机构")
    @RequestMapping("/save")
    public R save(@RequestBody SysBranchEntity branch) {
        return sysBranchService.saveBranch(branch);
    }

    /**
     * 查询详情
     * @param id
     * @return
     */
    @RequestMapping("/info")
    public R info(@RequestBody Long id) {
        return sysBranchService.getBranchById(id);
    }

    /**
     * 修改机构
     * @param branch
     * @return
     */
    @SysLog("修改机构")
    @RequestMapping("/update")
    public R update(@RequestBody SysBranchEntity branch) {
        return sysBranchService.updateBranch(branch);
    }

    /**
     * 删除机构
     * @param id
     * @return
     */
    @SysLog("删除机构")
    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] id) {
        return sysBranchService.batchRemoveBranch(id);
    }

}
