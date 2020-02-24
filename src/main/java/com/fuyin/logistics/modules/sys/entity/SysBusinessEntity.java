package com.fuyin.logistics.modules.sys.entity;

import java.io.Serializable;



/**
 * 商户
 */
public class SysBusinessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String fId;

    /**
     * 名称
     */
    private String fName;

    /**
     * 所属辖区代码
     */
    private String fDept;

    /**
     * 地址
     */
    private String fAddr;

    /**
     * 电话
     */
    private String fTel;

    /**
     * 手机
     */
    private String fMobile;

    /**
     * 是否安装监控,0:未安装,1:已安装
     */
    private String fState;

    /**
     * 安装时间
     */
    private String fInstdate;

    /**
     * SysBusinessEntity constructor
     */
    public SysBusinessEntity() {
        super();
    }

    /**
     * setter for fId
     * @param FID
     */
    public void setF_id(String FID) {
        this.fId = FID;
    }

    /**
     * getter for fId
     */
    public String getF_id() {
        return fId;
    }

    /**
     * setter for fName
     * @param f_name
     */
    public void setF_Name(String f_name) {
        this.fName = f_name;
    }

    /**
     * getter for fName
     */
    public String getF_Name() {
        return fName;
    }

    /**
     * setter for fDept
     * @param fDept
     */
    public void setFDept(String fDept) {
        this.fDept = fDept;
    }

    /**
     * getter for fDept
     */
    public String getFDept() {
        return fDept;
    }

    /**
     * setter for fAddr
     * @param fAddr
     */
    public void setFAddr(String fAddr) {
        this.fAddr = fAddr;
    }

    /**
     * getter for fAddr
     */
    public String getFAddr() {
        return fAddr;
    }

    /**
     * setter for fTel
     * @param fTel
     */
    public void setFTel(String fTel) {
        this.fTel = fTel;
    }

    /**
     * getter for fTel
     */
    public String getFTel() {
        return fTel;
    }

    /**
     * setter for fMobile
     * @param fMobile
     */
    public void setFMobile(String fMobile) {
        this.fMobile = fMobile;
    }

    /**
     * getter for fMobile
     */
    public String getFMobile() {
        return fMobile;
    }

    /**
     * setter for fState
     * @param fState
     */
    public void setFState(String fState) {
        this.fState = fState;
    }

    /**
     * getter for fState
     */
    public String getFState() {
        return fState;
    }

    /**
     * setter for fInstdate
     * @param fInstdate
     */
    public void setFInstdate(String fInstdate) {
        this.fInstdate = fInstdate;
    }

    /**
     * getter for fInstdate
     */
    public String getFInstdate() {
        return fInstdate;
    }

    /**
     * SysBusinessEntity.toString()
     */
    @Override
    public String toString() {
        return "SysBusinessEntity{" +
                "fId='" + fId + '\'' +
                ", fName='" + fName + '\'' +
                ", fDept='" + fDept + '\'' +
                ", fAddr='" + fAddr + '\'' +
                ", fTel='" + fTel + '\'' +
                ", fMobile='" + fMobile + '\'' +
                ", fState='" + fState + '\'' +
                ", fInstdate='" + fInstdate + '\'' +
                '}';
    }

}
