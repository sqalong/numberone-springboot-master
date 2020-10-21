package com.numberone.project.crm.order.domain;

import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 订单表 dk_order
 * 
 * @author numberone专业开发
 * @date 2019-06-07
 */
public class Order extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 部门ID */
	private Long deptId;
	/** 订单ID */
	private Long orderId;
	/** 姓名 */
	private String name;
	/** 手机号 */
	private String phone;
	/** 用户性别 */
	private String sex;
	/** 状态 */
	private String status;
	/** 身份证号 */
	private String idCard;
	/** 出生日期 */
	private Date birthday;
	/** 年龄 */
	private String age;
	/** 签约时间 */
	private Date signTime;
	/** 客服经理ID */
	private Long managerId;
	/** 客服经理姓名 */
	private String managerName;
	/** 贷款方式 */
	private String dkType;
	/** 还款方式 */
	private String hkType;
	/** 申请金额 */
	private Double applyMoney;
	/** 还款期数 */
	private Integer period;
	/** 信息服务费 */
	private Double serviceMoney;
	/** 客户ID */
	private Long customerId;
	/** 客服经理部门ID */
	private Long managerDeptId;

	public static final String STATUS_SUBMIT = "0";//提交状态
	public static final String STATUS_CONFIRM = "1";//确认放款
	public static final String STATUS_REFUSE= "2";//作废
	public static final String STATUS_HK= "3";//确认回款
	public static final String STATUS_ACCEPT = "4";//已接单

	public void setOrderId(Long orderId) 
	{
		this.orderId = orderId;
	}

	public Long getOrderId() 
	{
		return orderId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setIdCard(String idCard) 
	{
		this.idCard = idCard;
	}

	public String getIdCard() 
	{
		return idCard;
	}
	public void setBirthday(Date birthday) 
	{
		this.birthday = birthday;
	}

	public Date getBirthday() 
	{
		return birthday;
	}
	public void setAge(String age) 
	{
		this.age = age;
	}

	public String getAge() 
	{
		return age;
	}
	public void setSignTime(Date signTime) 
	{
		this.signTime = signTime;
	}

	public Date getSignTime() 
	{
		return signTime;
	}
	public void setManagerId(Long managerId) 
	{
		this.managerId = managerId;
	}

	public Long getManagerId() 
	{
		return managerId;
	}
	public void setManagerName(String managerName) 
	{
		this.managerName = managerName;
	}

	public String getManagerName() 
	{
		return managerName;
	}
	public void setDkType(String dkType) 
	{
		this.dkType = dkType;
	}

	public String getDkType() 
	{
		return dkType;
	}
	public void setHkType(String hkType) 
	{
		this.hkType = hkType;
	}

	public String getHkType() 
	{
		return hkType;
	}
	public void setApplyMoney(Double applyMoney) 
	{
		this.applyMoney = applyMoney;
	}

	public Double getApplyMoney() 
	{
		return applyMoney;
	}
	public void setPeriod(Integer period) 
	{
		this.period = period;
	}

	public Integer getPeriod() 
	{
		return period;
	}
	public void setServiceMoney(Double serviceMoney) 
	{
		this.serviceMoney = serviceMoney;
	}

	public Double getServiceMoney() 
	{
		return serviceMoney;
	}
	public void setCustomerId(Long customerId) 
	{
		this.customerId = customerId;
	}

	public Long getCustomerId() 
	{
		return customerId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getManagerDeptId() {
		return managerDeptId;
	}

	public void setManagerDeptId(Long managerDeptId) {
		this.managerDeptId = managerDeptId;
	}

	public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("sex", getSex())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("idCard", getIdCard())
            .append("birthday", getBirthday())
            .append("age", getAge())
            .append("signTime", getSignTime())
            .append("managerId", getManagerId())
            .append("managerName", getManagerName())
            .append("dkType", getDkType())
            .append("hkType", getHkType())
            .append("applyMoney", getApplyMoney())
            .append("period", getPeriod())
            .append("serviceMoney", getServiceMoney())
            .append("customerId", getCustomerId())
            .toString();
    }
}
