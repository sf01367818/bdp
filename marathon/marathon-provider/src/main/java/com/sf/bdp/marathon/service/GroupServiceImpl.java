package com.sf.bdp.marathon.service;

import com.sf.bdp.marathon.dao.GroupDao;
import com.sf.bdp.marathon.dao.MarketBaseDao;
import com.sf.bdp.marathon.entity.Group;
import javax.annotation.Resource;

import com.sf.bdp.marathon.entity.MarketBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 集货团用户关系表Service实现类
 *
 * @author 01368020
 */
@Service("groupService")
@Transactional(rollbackFor = Exception.class)
public class GroupServiceImpl implements GroupService {

  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  @Resource
  private GroupDao groupDao;

  @Resource
  private MarketBaseDao marketBaseDao;

  @Override
  public Group getGroup(String groupId) {
    return groupDao.find(groupId);
  }

  @Override
  public Group getCurrentGroup(String mktId) {
    return groupDao.getCurrentGroup(mktId);
  }

  @Override
  public Group createGroup(String mktId) {
    MarketBase marketBase = marketBaseDao.find(mktId);
    Date startTime = new Date();
    Date endTime = new Date(startTime.getTime() + marketBase.getGroupDuration() * 60000);
    Group group = new Group();
    group.setStartTime(startTime);
    group.setEndTime(endTime);
    group.setMktId(marketBase.getMktId());
    group.setGroupLimit(marketBase.getGroupLimit());
    group.setGroupName(marketBase.getMktNameShow() + sdf.format(startTime));
    groupDao.save(group);
    return group;
  }
}
