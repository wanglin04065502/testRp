package com.fuyin.logistics.modules.sys.entity;

import java.io.Serializable;
import java.util.List;

import com.fuyin.logistics.common.utils.CommonUtils;

/**
 * 机构
 */
public class SysBranchEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构代码
     */
    private String id;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 上级代码，省级为0000
     */
    private String dept;

    /**
     * 上级名称
     */
    private String deptname;

    /**
     * 综合编号
     */
    private String deptid;

    /**
     * 层级，1：地市，2：区县，3：街道
     */
    private String level;

    /**
     * 地址
     */
    private String addr;

    /**
     * 电话
     */
    private String tel;


    /**
     * ztree属性
     */
    private Boolean open;

    private Boolean isParent;

    private Integer size;

    private List<?> list;

    public SysBranchEntity() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public void checkParent() {
        if(CommonUtils.isIntThanZero(this.size)) {
            this.isParent = true;
        } else {
            this.isParent = false;
        }
    }

    public void checkDeptName() {
        if(this.dept.equals("0000")) {
            this.dept = "省级机构";
        }
    }

}
