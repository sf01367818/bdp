package com.sf.bdp.marathon.service;

import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.entity.Group;

/**
 * 集货团用户Service
 *
 * @author
 */
public interface GroupService {

  /**
   * 生成集货团用户关系
   *
   * @param group
   * @return
   */
  Response gernateGroup(Group group);

}
