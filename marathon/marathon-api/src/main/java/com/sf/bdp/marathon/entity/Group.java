package com.sf.bdp.marathon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "pro_group")
public class Group implements Serializable {

	private static final long serialVersionUID = -7653196989988338521L;
	@Id
	@Column(name="group_id",columnDefinition = ("varchar(36) not null comment '集货团ID'"))
	@GeneratedValue(generator = "uuid") 
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String groupId;
	@Column(name="mkt_id",columnDefinition = ("varchar(36) not null comment '专业市场ID'"))
	private String mktId;
	@Column(name = "start_time", columnDefinition = ("datetime not null comment '开始时间'"))
	private Date startTime;
	@Column(name = "end_time", columnDefinition = ("datetime not null comment '结束时间'"))
	private Date endTime;
	@Column(name = "group_name", columnDefinition = ("varchar(150) not null comment '集货团名称'"))
	private String groupName;
	@Column(name = "group_limit", columnDefinition = ("smallint comment '成团人数'"))
	private Short groupLimit;

	public Short getGroupLimit() {
		return groupLimit;
	}

	public void setGroupLimit(Short groupLimit) {
		this.groupLimit = groupLimit;
	}

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getMktId() {
		return mktId;
	}
	public void setMktId(String mktId) {
		this.mktId = mktId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
