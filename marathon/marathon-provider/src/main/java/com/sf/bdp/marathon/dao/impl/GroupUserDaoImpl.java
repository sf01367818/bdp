package com.sf.bdp.marathon.dao.impl;

import com.sf.bdp.marathon.dao.GroupUserDao;
import com.sf.bdp.marathon.entity.GroupUser;

import java.math.BigInteger;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * 集货团用户关系表dao接口实现类
 *
 * @author 01368020
 */
@Repository
public class GroupUserDaoImpl extends BaseDaoImpl<GroupUser, Integer> implements GroupUserDao {

  /**
   * @see com.sf.bdp.marathon.dao.GroupUserDao#getUserCountByGroupId(String)
   */
  @Override
  public Integer getUserCountByGroupId(String id) {
    String sql = "select count(*) from pro_group_user where group_id = ?";
    Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
    query.setParameter(0, id);
    BigInteger num = (BigInteger) query.uniqueResult();
    return num.intValue();
  }
  
}
