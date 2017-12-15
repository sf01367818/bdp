package com.sf.bdp.marathon.service;

import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.entity.GroupUser;

/**
 * 集货团用户Service
 *
 * @author 01368020
 */
public interface GroupUserService {

  /**
   * 添加集货团用户关系，如果当前集货团有效，则加入当前期，失效则返回下一期的集货团id
   *
   * @param groupUser
   * @return Response
   * @author 01368020
   */
  @SuppressWarnings("rawtypes")
  Response addGroupUser(GroupUser groupUser);

  /**
   * 根据集货团id查询用户数量
   *
   * @param id
   * @return
   * @author 01368020
   */
  Integer queryUserCountByGroupId(String id);

}
