package com.sf.bdp.marathon.control;

import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.entity.GroupUser;
import com.sf.bdp.marathon.service.GroupUserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 集货团用户关系表controller类
 *
 * @author 01368020
 */
@Controller
@RequestMapping(value = "groupuser", produces = "application/json; charset=UTF-8")
public class GroupUserController {

  @Resource
  private GroupUserService groupUserService;

  @RequestMapping("add")
  @ResponseBody
  public Response get(GroupUser groupUser) {
    try {
      return Response.ok(groupUserService.addGroupUser(groupUser));
    } catch (Exception e) {
      return Response.error("连接dubbo服务失败");
    }
  }
}
