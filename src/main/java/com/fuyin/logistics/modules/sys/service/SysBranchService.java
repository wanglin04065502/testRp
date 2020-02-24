package com.fuyin.logistics.modules.sys.service;

import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.modules.sys.entity.SysBranchEntity;

import java.util.List;
import java.util.Map;

/**
 * 机构
 */
public interface SysBranchService {

    /**
     * 根据父级id查询机构：ztree异步数据源
     * @param id
     * @return
     */
    List<SysBranchEntity> listBranchByDept(String id);

    /**
     * 根据父级id查询机构：表格数据源
     * @param params
     * @return
     */
    R listBranchByDept(Map<String, Object> params);

    /**
     * 新增机构
     * @param branch
     * @return
     */
    R saveBranch(SysBranchEntity branch);

    /**
     * 根据id查询机构
     * @param id
     * @return
     */
    R getBranchById(Long id);

    /**
     * 修改机构
     * @param branch
     * @return
     */
    R updateBranch(SysBranchEntity branch);

    /**
     * 批量删除机构
     * @param id
     * @return
     */
    R batchRemoveBranch(Long[] id);

}
