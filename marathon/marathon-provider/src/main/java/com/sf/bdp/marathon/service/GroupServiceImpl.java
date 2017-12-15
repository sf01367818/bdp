package com.sf.bdp.marathon.service;

import com.sf.bdp.marathon.dao.GroupDao;
import com.sf.bdp.marathon.entity.Group;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 集货团用户关系表Service实现类
 *
 * @author 01368020
 */
@Service("groupService")
@Transactional(rollbackFor = Exception.class)
public class GroupServiceImpl implements GroupService {

  @Resource
  private GroupDao groupDao;

  @Override
  public Group getGroup(String groupId) {
    return groupDao.find(groupId);
  }

  @Override
  public Group getCurrentGroup(String mktId) {
    return groupDao.getCurrentGroup(mktId);
  }

}
