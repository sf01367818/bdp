package com.sf.bdp.marathon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pro_group_user")
public class GroupUser implements Serializable {

	private static final long serialVersionUID = -3479439467003051023L;

	@Column(name = "group_id", columnDefinition = ("varchar(36) not null comment '姓名'"))
	private String groupId;
	@Column(name = "user_id", columnDefinition = ("varchar(36) not null comment '姓名'"))
	private String userId;
	@Column(name = "send_address", columnDefinition = ("varchar(255) default null comment '寄件地址'"))
	private String sendAddress;
	@Column(name = "send_user_name", columnDefinition = ("varchar(50) default null comment '用户姓名'"))
	private String sendUserName;
	@Column(name = "send_phone", columnDefinition = ("varchar(50) default null comment '寄方电话号码'"))
	private String sendPhone;
	@Column(name = "receive_address", columnDefinition = ("varchar(255) default null comment '收件地址'"))
	private String receiveAddress;
	@Column(name="daily_expect_packages",columnDefinition = ("smallint comment '预估每日件量'"))
	private Short dailyExpectPackages;
	@Column(name="send_packages",columnDefinition = ("smallint comment '寄件数量'"))
	private Short sendPackages;
	@Column(name="weight",columnDefinition = ("decimal comment '重量'"))
	private Float weight;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	public String getSendUserName() {
		return sendUserName;
	}
	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}
	public String getSendPhone() {
		return sendPhone;
	}
	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public Short getDailyExpectPackages() {
		return dailyExpectPackages;
	}
	public void setDailyExpectPackages(Short dailyExpectPackages) {
		this.dailyExpectPackages = dailyExpectPackages;
	}
	public Short getSendPackages() {
		return sendPackages;
	}
	public void setSendPackages(Short sendPackages) {
		this.sendPackages = sendPackages;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
}
