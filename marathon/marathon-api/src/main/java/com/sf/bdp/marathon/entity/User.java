package com.sf.bdp.marathon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pro_user")
public class User implements Serializable {

	private static final long serialVersionUID = -3479439467003051023L;

	@Id
	@Column(name="user_id",columnDefinition = ("varchar(36) not null comment '用户ID'"))
	@GeneratedValue(generator = "uuid") 
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String userId;
	@Column(name = "name", columnDefinition = ("varchar(150) not null comment '姓名'"))
	private String name;
	@Column(name = "phone", columnDefinition = ("varchar(50) default null comment '电话号码'"))
	private String phone;
	@Column(name = "receive_address", columnDefinition = ("varchar(255) default null comment '收件地址'"))
	private String receiveAddress;
	@Column(name = "send_address", columnDefinition = ("varchar(255) default null comment '寄件地址'"))
	private String sendAddress;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public String getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
}
