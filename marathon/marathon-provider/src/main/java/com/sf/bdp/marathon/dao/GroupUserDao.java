package com.sf.bdp.marathon.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.sf.bdp.marathon.entity.GroupUser;

/**
 * 集货团用户关系表dao接口
 *
 * @author 01368020
 */
public interface GroupUserDao extends GenericDAO<GroupUser, Integer> {

  /**
   * 获取当前团报名的用户数量
   *
   * @param id
   * @return
   * @author 01368020
   */
  public Integer getUserCountByGroupId(String id);

}
