package com.sf.bdp.marathon.dao.impl;

import org.springframework.stereotype.Repository;

import com.sf.bdp.marathon.dao.UserDao;
import com.sf.bdp.marathon.entity.User;


@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

}
