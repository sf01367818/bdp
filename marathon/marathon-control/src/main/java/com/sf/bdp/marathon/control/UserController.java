package com.sf.bdp.marathon.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.entity.User;
import com.sf.bdp.marathon.service.UserService;

@Controller
@RequestMapping(value = "user", produces = "application/json; charset=UTF-8")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("get")
	@ResponseBody
	public Response<User> get(String id) {
		try {
			return Response.ok(userService.get(id));
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
}
