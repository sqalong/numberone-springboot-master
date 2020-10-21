package com.numberone.project.crm.customer.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 客户表 dk_customer
 * 
 * @author numberone专业开发
 * @date 2019-06-05
 */
public class Customer extends BaseEntity
{
	private static final long serialVersionUID = 1L;


	/** 部门ID */
	private Long deptId;
	/** 客户ID */
	private Long customerId;
	/** 姓名 */
	@Excel(name = "姓名")
	private String name;
	/** 手机号 */
	@Excel(name = "手机号")
	private String phone;
	/** 用户邮箱 */
	private String email;
	/** 用户性别（0男 1女 2未知） */
	private String sex;
	/** 客户状态 */
	private String status;
	/** 身份证号 */
	private String idCard;
	/** 出生日期 */
	private Date birthday;
	/** 学历 */
	private String qualification;
	/** 省份 */
	private String province;
	/** 城市 */
	private String city;
	/** 婚姻状态 */
	private String marriage;
	/** 家庭住址 */
	private String address;
	/** 客户类型 */
	private String type;
	/** 级别 */
	private String level;
	/** 来源 */
	private String source;
	/** 客户经理ID */
	private Long managerId;
	/** 客户经理姓名 */
	private String managerName;
	/** 话务员ID */
	private Long hwyId;
	/** 话务员姓名 */
	private String hwyName;
	/** 资金需求 */
	@Excel(name = "贷款金额(万)")
	private Double moneyRequire;
	/** 资金用途*/
	private String moneyUse;
	/** 下次跟进时间 */
	private Date nextFollowDate;
	/** 客户状态2 */
	private String status2;
	/** 房产 */
	private String fc;
	/** 车辆 */
	private String car;
	/** 保险 */
	private String bx;
	/** 信用卡 */
	private String creditCard;
	/** 负债 */
	private String fz;
	/**  */
	private String contact;
	/** 跟进 */
	private String follow;
	/** 签约 */
	private String contract;
	/** 收款 */
	private String sk;
	/** 跟进时间 */
	private Date followTime;
	/** 自定义查询条件 */
	private String customerSql;
	@Excel(name = "其他")
	private String remark;

	public void setCustomerId(Long customerId) 
	{
		this.customerId = customerId;
	}

	public Long getCustomerId() 
	{
		return customerId;
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
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
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
	public void setQualification(String qualification) 
	{
		this.qualification = qualification;
	}

	public String getQualification() 
	{
		return qualification;
	}
	public void setProvince(String province) 
	{
		this.province = province;
	}

	public String getProvince() 
	{
		return province;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	public void setMarriage(String marriage) 
	{
		this.marriage = marriage;
	}

	public String getMarriage() 
	{
		return marriage;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	public void setLevel(String level) 
	{
		this.level = level;
	}

	public String getLevel() 
	{
		return level;
	}
	public void setSource(String source) 
	{
		this.source = source;
	}

	public String getSource() 
	{
		return source;
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
	public void setHwyId(Long hwyId) 
	{
		this.hwyId = hwyId;
	}

	public Long getHwyId() 
	{
		return hwyId;
	}
	public void setHwyName(String hwyName) 
	{
		this.hwyName = hwyName;
	}

	public String getHwyName() 
	{
		return hwyName;
	}
	public void setMoneyRequire(Double moneyRequire) 
	{
		this.moneyRequire = moneyRequire;
	}

	public Double getMoneyRequire() 
	{
		return moneyRequire;
	}
	public void setMoneyUse(String moneyUse) 
	{
		this.moneyUse = moneyUse;
	}

	public String getMoneyUse() 
	{
		return moneyUse;
	}
	public void setNextFollowDate(Date nextFollowDate) 
	{
		this.nextFollowDate = nextFollowDate;
	}

	public Date getNextFollowDate() 
	{
		return nextFollowDate;
	}
	public void setStatus2(String status2) 
	{
		this.status2 = status2;
	}

	public String getStatus2() 
	{
		return status2;
	}
	public void setFc(String fc) 
	{
		this.fc = fc;
	}

	public String getFc() 
	{
		return fc;
	}
	public void setCar(String car) 
	{
		this.car = car;
	}

	public String getCar() 
	{
		return car;
	}
	public void setBx(String bx) 
	{
		this.bx = bx;
	}

	public String getBx() 
	{
		return bx;
	}
	public void setCreditCard(String creditCard) 
	{
		this.creditCard = creditCard;
	}

	public String getCreditCard() 
	{
		return creditCard;
	}
	public void setFz(String fz) 
	{
		this.fz = fz;
	}

	public String getFz() 
	{
		return fz;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}

	public String getContact() 
	{
		return contact;
	}
	public void setFollow(String follow) 
	{
		this.follow = follow;
	}

	public String getFollow() 
	{
		return follow;
	}
	public void setContract(String contract) 
	{
		this.contract = contract;
	}

	public String getContract() 
	{
		return contract;
	}
	public void setSk(String sk) 
	{
		this.sk = sk;
	}

	public String getSk() 
	{
		return sk;
	}

	public Date getFollowTime() {
		return followTime;
	}

	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}

	public String getCustomerSql() {
		return customerSql;
	}

	public void setCustomerSql(String customerSql) {
		this.customerSql = customerSql;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("customerId", getCustomerId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("sex", getSex())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("idCard", getIdCard())
            .append("birthday", getBirthday())
            .append("qualification", getQualification())
            .append("province", getProvince())
            .append("city", getCity())
            .append("marriage", getMarriage())
            .append("address", getAddress())
            .append("type", getType())
            .append("level", getLevel())
            .append("source", getSource())
            .append("managerId", getManagerId())
            .append("managerName", getManagerName())
            .append("hwyId", getHwyId())
            .append("hwyName", getHwyName())
            .append("moneyRequire", getMoneyRequire())
            .append("moneyUse", getMoneyUse())
            .append("nextFollowDate", getNextFollowDate())
            .append("status2", getStatus2())
            .append("fc", getFc())
            .append("car", getCar())
            .append("bx", getBx())
            .append("creditCard", getCreditCard())
            .append("fz", getFz())
            .append("contact", getContact())
            .append("follow", getFollow())
            .append("contract", getContract())
            .append("sk", getSk())
            .toString();
    }

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
