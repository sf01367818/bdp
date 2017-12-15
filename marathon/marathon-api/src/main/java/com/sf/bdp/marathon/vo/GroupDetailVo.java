package com.sf.bdp.marathon.vo;

import java.io.Serializable;
import com.sf.bdp.marathon.entity.Group;
import com.sf.bdp.marathon.entity.MarketBase;

public class GroupDetailVo implements Serializable  {

	private static final long serialVersionUID = 1389548789865314451L;

	private Group group;
	private MarketBase marketBase;
	private Integer userNum;
	
	public GroupDetailVo(){}
	
	public GroupDetailVo(Group group,MarketBase marketBase,Integer userNum){
		this.group = group;
		this.marketBase = marketBase;
		this.userNum = userNum;
	}
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public MarketBase getMarketBase() {
		return marketBase;
	}
	public void setMarketBase(MarketBase marketBase) {
		this.marketBase = marketBase;
	}
	public Integer getUserNum() {
		return userNum;
	}
	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}
}
