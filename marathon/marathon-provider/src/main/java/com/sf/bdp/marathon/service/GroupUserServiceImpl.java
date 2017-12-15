package com.sf.bdp.marathon.service;

import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.dao.GroupDao;
import com.sf.bdp.marathon.dao.GroupUserDao;
import com.sf.bdp.marathon.entity.Group;
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
  private GroupService groupService;

  @Resource
  private GroupUserDao groupUserDao;

  @Resource
  private GroupDao groupDao;

  /**
   * @see com.sf.bdp.marathon.service.GroupUserService#addGroupUser(GroupUser)
   */
  @Override
  public Response addGroupUser(GroupUser groupUser) {
    Group group = groupDao.find(groupUser.getGroupId());
    Integer userCount = groupUserDao.getUserCountByGroupId(groupUser.getGroupId());
    if (group.getGroupLimit() <= userCount || System.currentTimeMillis() > group.getEndTime().getTime()) {
      Group currentGroup = groupService.createGroup(group.getMktId());
      return Response.error(currentGroup.getGroupId());
    } else {
      groupUserDao.save(groupUser);
      return Response.ok(groupUser.getGroupId());
    }
  }

  @Override
  public Integer queryUserCountByGroupId(String id) {
    return groupUserDao.getUserCountByGroupId(id);
  }
}
