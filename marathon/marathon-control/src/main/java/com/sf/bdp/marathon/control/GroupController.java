package com.sf.bdp.marathon.control;

import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.entity.Group;
import com.sf.bdp.marathon.entity.MarketBase;
import com.sf.bdp.marathon.service.GroupService;
import com.sf.bdp.marathon.service.GroupUserService;
import com.sf.bdp.marathon.service.MarketBaseService;
import com.sf.bdp.marathon.vo.GroupDetailVo;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 集货团用户关系表controller类
 * @author 01368020
 */
@Controller
@RequestMapping(value = "group", produces = "application/json; charset=UTF-8")
public class GroupController {
	static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);
	
	@Resource
	private GroupService groupService;
	@Resource
	private MarketBaseService marketBaseService;
	
	private GroupUserService groupUserService;

	@RequestMapping("getGroupDetail")
	@ResponseBody
	public Response getGroupDetail(String groupId) {
		try {
			Group group = groupService.getGroup(groupId);
			if (group.getEndTime().getTime() < System.currentTimeMillis()) {
				group = groupService.getCurrentGroup(group.getMktId());
			}
			MarketBase marketBase = marketBaseService.getMarkBase(group.getMktId());
			Integer userNum = groupUserService.queryUserCountByGroupId(group.getGroupId());
			GroupDetailVo vo = new GroupDetailVo(group,marketBase,userNum);
			return Response.ok(vo);
		} catch (Exception e) {
			LOGGER.error("get current group error",e);
			return Response.error(e.getMessage());
		}
	}

}
