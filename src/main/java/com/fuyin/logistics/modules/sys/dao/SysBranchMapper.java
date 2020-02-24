package com.fuyin.logistics.modules.sys.dao;

import com.fuyin.logistics.modules.sys.entity.SysBranchEntity;
import com.fuyin.logistics.common.entity.Query;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 机构
 */
@Mapper
public interface SysBranchMapper extends BaseMapper<SysBranchEntity> {

    /**
     * 根据父计编码查询
     * @param query
     * @return
     */
    List<SysBranchEntity> listBranchByDept(Query query);

    /**
     * 子节点总数
     * @param id
     * @return
     */
    int countBranchChildren(Long id);

}
