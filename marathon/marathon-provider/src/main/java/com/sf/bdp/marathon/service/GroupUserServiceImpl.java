package com.sf.bdp.marathon.service;

import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.dao.GroupUserDao;
import com.sf.bdp.marathon.entity.GroupUser;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 集货团用户关系表Service实现类
 *
 * @author 01368020
 */
@Service("groupUserService")
@Transactional(rollbackFor = Exception.class)
public class GroupUserServiceImpl implements GroupUserService {

  @Resource
  private GroupUserDao groupUserDao;

  @Override
  public Response addGroupUser(GroupUser groupUser) {
    if (groupUserDao.save(groupUser)) {
      return Response.ok("保存集货团用户成功");
    } else {
      return Response.error("保存集货团用户失败");
    }
  }

  @Override
  public Response queryUserCountByGroupId(String id) {
    return null;
  }
}
