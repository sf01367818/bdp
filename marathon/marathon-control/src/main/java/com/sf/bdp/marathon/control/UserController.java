package com.sf.bdp.marathon.control;

import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "user", produces = "application/json; charset=UTF-8")
public class UserController {

  @Resource
  private UserService userService;

  @RequestMapping("get")
  @ResponseBody
  public Response get(String id) {
    try {
      return Response.ok(userService.get(id));
    } catch (Exception e) {
      return Response.error(e.getMessage());
    }
  }
}
