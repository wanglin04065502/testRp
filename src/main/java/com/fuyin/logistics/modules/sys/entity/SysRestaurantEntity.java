package com.fuyin.logistics.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 商户
 */
public class SysRestaurantEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编号
	 */
	private String id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 所属辖区代码
	 */
	private String dept;
	
	/**
	 * 地址
	 */
	private String addr;
	
	/**
	 * 电话
	 */
	private String tel;
	
	/**
	 * 手机
	 */
	private String mobile;
	
	/**
	 * 是否安装监控,0:未安装,1:已安装
	 */
	private String state;
	
	/**
	 * 安装时间
	 */
	private String instdate;
	
	/**
	 * 
	 */
	private String pad1;
	
	/**
	 * 
	 */
	private String pad2;
	
    /**
     * SysRestaurantEntity constructor
     */
	public SysRestaurantEntity() {
		super();
	}

    /**
     * setter for id
     * @param id
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * getter for id
     */
	public String getId() {
		return id;
	}

    /**
     * setter for name
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * getter for name
     */
	public String getName() {
		return name;
	}

    /**
     * setter for dept
     * @param dept
     */
	public void setDept(String dept) {
		this.dept = dept;
	}

    /**
     * getter for dept
     */
	public String getDept() {
		return dept;
	}

    /**
     * setter for addr
     * @param addr
     */
	public void setAddr(String addr) {
		this.addr = addr;
	}

    /**
     * getter for addr
     */
	public String getAddr() {
		return addr;
	}

    /**
     * setter for tel
     * @param tel
     */
	public void setTel(String tel) {
		this.tel = tel;
	}

    /**
     * getter for tel
     */
	public String getTel() {
		return tel;
	}

    /**
     * setter for mobile
     * @param mobile
     */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

    /**
     * getter for mobile
     */
	public String getMobile() {
		return mobile;
	}

    /**
     * setter for state
     * @param state
     */
	public void setState(String state) {
		this.state = state;
	}

    /**
     * getter for state
     */
	public String getState() {
		return state;
	}

    /**
     * setter for instdate
     * @param instdate
     */
	public void setInstdate(String instdate) {
		this.instdate = instdate;
	}

    /**
     * getter for instdate
     */
	public String getInstdate() {
		return instdate;
	}

    /**
     * setter for pad1
     * @param pad1
     */
	public void setPad1(String pad1) {
		this.pad1 = pad1;
	}

    /**
     * getter for pad1
     */
	public String getPad1() {
		return pad1;
	}

    /**
     * setter for pad2
     * @param pad2
     */
	public void setPad2(String pad2) {
		this.pad2 = pad2;
	}

    /**
     * getter for pad2
     */
	public String getPad2() {
		return pad2;
	}

    /**
     * SysRestaurantEntity.toString()
     */
    @Override
    public String toString() {
        return "SysRestaurantEntity{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", dept='" + dept + '\'' +
               ", addr='" + addr + '\'' +
               ", tel='" + tel + '\'' +
               ", mobile='" + mobile + '\'' +
               ", state='" + state + '\'' +
               ", instdate='" + instdate + '\'' +
               ", pad1='" + pad1 + '\'' +
               ", pad2='" + pad2 + '\'' +
               '}';
    }

}
