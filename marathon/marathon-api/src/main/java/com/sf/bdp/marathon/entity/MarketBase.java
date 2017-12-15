package com.sf.bdp.marathon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pro_market_base")
public class MarketBase implements Serializable {
	
	private static final long serialVersionUID = 1337718021661802250L;
	
	@Id
	@Column(name="MKT_ID",columnDefinition = ("varchar(36) not null comment '专业市场ID'"))
	@GeneratedValue(generator = "uuid") 
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String mktId;
	@Column(name="MKT_NAME_SHOW",columnDefinition = ("varchar(50) not null comment '市场外部名称'"))
	private String mktNameShow;
	@Column(name="DAILY_MIN_PACKAGES",columnDefinition = ("smallint comment '单客日均最小件量'"))
	private Short dailyMinPackages;	
	@Column(name="WEIGHT_MIN",columnDefinition = ("decimal comment '重量区间（最小）'"))
	private Float weightMin;
	@Column(name="WEIGHT_MAX",columnDefinition = ("decimal comment '首重价格'"))
	private Float weightMax;
	@Column(name="BASE_PRICE",columnDefinition = ("decimal comment '首重价格'"))
	private Float basePrice;
	@Column(name="BASE_WEIGHT",columnDefinition = ("decimal comment '首重重量'"))
	private Float baseWeight;
	@Column(name="GROUP_LIMIT",columnDefinition = ("smallint comment '成团人数'"))
	private Short groupLimit;
	@Column(name="GROUP_DURATION",columnDefinition = ("tinyint comment '拼团周期'"))
	private Short groupDuration;
	@Column(name="USE_REQUIRE",columnDefinition = ("text comment '使用要求'"))
	private Short useRequire;//	使用要求
	public String getMktId() {
		return mktId;
	}
	public void setMktId(String mktId) {
		this.mktId = mktId;
	}
	public String getMktNameShow() {
		return mktNameShow;
	}
	public void setMktNameShow(String mktNameShow) {
		this.mktNameShow = mktNameShow;
	}
	public Short getDailyMinPackages() {
		return dailyMinPackages;
	}
	public void setDailyMinPackages(Short dailyMinPackages) {
		this.dailyMinPackages = dailyMinPackages;
	}
	public Float getWeightMin() {
		return weightMin;
	}
	public void setWeightMin(Float weightMin) {
		this.weightMin = weightMin;
	}
	public Float getWeightMax() {
		return weightMax;
	}
	public void setWeightMax(Float weightMax) {
		this.weightMax = weightMax;
	}
	public Float getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}
	public Float getBaseWeight() {
		return baseWeight;
	}
	public void setBaseWeight(Float baseWeight) {
		this.baseWeight = baseWeight;
	}
	public Short getGroupLimit() {
		return groupLimit;
	}
	public void setGroupLimit(Short groupLimit) {
		this.groupLimit = groupLimit;
	}
	public Short getGroupDuration() {
		return groupDuration;
	}
	public void setGroupDuration(Short groupDuration) {
		this.groupDuration = groupDuration;
	}
	public Short getUseRequire() {
		return useRequire;
	}
	public void setUseRequire(Short useRequire) {
		this.useRequire = useRequire;
	}

}
