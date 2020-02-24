package com.fuyin.logistics.modules.sys.service.impl;

import com.fuyin.logistics.common.constant.MsgConstant;
import com.fuyin.logistics.common.entity.Query;
import com.fuyin.logistics.common.entity.R;
import com.fuyin.logistics.common.utils.CommonUtils;
import com.fuyin.logistics.modules.sys.dao.SysBranchMapper;
import com.fuyin.logistics.modules.sys.entity.SysBranchEntity;
import com.fuyin.logistics.modules.sys.service.SysBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 行政区域
 */
@Service("sysBranchService")
public class SysBranchServiceImpl implements SysBranchService {

    @Autowired
    private SysBranchMapper sysBranchMapper;

    /**
     * 根据父级id查询区域：ztree异步数据源
     * @param id
     * @return
     */
    @Override
    public List<SysBranchEntity> listBranchByDept(String id) {
        Query query = new Query();
        query.put("dept", id);
        List<SysBranchEntity> branchs = sysBranchMapper.listBranchByDept(query);
        for(SysBranchEntity branch : branchs) {
            branch.checkParent();
        }
        return branchs;
    }

    /**
     * 新增区域
     * @param branch
     * @return
     */
    @Override
    public R saveBranch(SysBranchEntity branch) {
        branch.setDeptid(branch.getDeptid()+","+branch.getId());
        int count = sysBranchMapper.save(branch);
        return CommonUtils.msg(count);
    }

    /**
     * 根据id查询区域
     * @param id
     * @return
     */
    @Override
    public R getBranchById(Long id) {
        SysBranchEntity branch = sysBranchMapper.getObjectById(id);
        branch.checkDeptName();
        return CommonUtils.msg(branch);
    }

    /**
     * 修改区域
     * @param branch
     * @return
     */
    @Override
    public R updateBranch(SysBranchEntity branch) {
        int count = sysBranchMapper.update(branch);
        return CommonUtils.msg(count);
    }

    /**
     * 批量删除区域
     * @param id
     * @return
     */
    @Override
    public R batchRemoveBranch(Long[] id) {
        boolean children = false;
        for(Long typeId : id) {
            int count = sysBranchMapper.countBranchChildren(typeId);
            if(CommonUtils.isIntThanZero(count)) {
                children = true;
            }
        }
        if(children) {
            return R.error(MsgConstant.MSG_HAS_CHILD);
        }
        int count = sysBranchMapper.batchRemove(id);
        return CommonUtils.msg(id, count);
    }

    /**
     * 根据父级id查询区域：表格数据源
     * @param params
     * @return
     */
    @Override
    public R listBranchByDept(Map<String, Object> params) {
        Query query = new Query(params);
        List<SysBranchEntity> branchs = sysBranchMapper.listBranchByDept(query);
        return CommonUtils.msg(branchs);
    }

}
