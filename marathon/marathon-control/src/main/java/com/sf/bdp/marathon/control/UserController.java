package com.sf.bdp.marathon.control;

import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.service.UserService;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "user", produces = "application/json; charset=UTF-8")
public class UserController {

  private static final Logger logger = Logger.getLogger(UserController.class);

  @Resource
  private UserService userService;

  @RequestMapping("get")
  @ResponseBody
  public Response get(String id) {
    try {
      return Response.ok(userService.get(id));
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return Response.error(e.getMessage());
    }
  }
}
