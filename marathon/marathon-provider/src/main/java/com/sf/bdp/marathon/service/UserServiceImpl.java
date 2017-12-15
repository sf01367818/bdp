package com.sf.bdp.marathon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sf.bdp.marathon.dao.UserDao;
import com.sf.bdp.marathon.entity.User;
import com.sf.bdp.marathon.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public User get(int id) {
		return userDao.find(id);
	}

}
