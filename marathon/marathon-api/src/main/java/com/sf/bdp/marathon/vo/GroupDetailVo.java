package com.sf.bdp.marathon.vo;

import java.io.Serializable;
import com.sf.bdp.marathon.entity.Group;
import com.sf.bdp.marathon.entity.MarketBase;

public class GroupDetailVo implements Serializable  {

	private static final long serialVersionUID = 1389548789865314451L;

	private Group group;
	private MarketBase marketBase;
	
	public GroupDetailVo(){}
	
	public GroupDetailVo(Group group,MarketBase marketBase){
		this.group = group;
		this.marketBase = marketBase;
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
}
