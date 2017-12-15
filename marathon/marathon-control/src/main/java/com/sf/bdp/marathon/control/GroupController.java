package com.sf.bdp.marathon.control;

import com.sf.bdp.marathon.service.GroupService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 集货团用户关系表controller类
 *
 * @author 01368020
 */
@Controller
@RequestMapping(value = "group", produces = "application/json; charset=UTF-8")
public class GroupController {

  @Resource
  private GroupService groupService;

}
