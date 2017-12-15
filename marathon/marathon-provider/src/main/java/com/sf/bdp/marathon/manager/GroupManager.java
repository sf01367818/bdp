package com.sf.bdp.marathon.manager;

import com.sf.bdp.marathon.dao.GroupDao;
import com.sf.bdp.marathon.dao.MarketBaseDao;
import com.sf.bdp.marathon.entity.Group;
import com.sf.bdp.marathon.entity.MarketBase;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GroupManager implements Runnable {

    private static final Logger logger = Logger.getLogger(GroupManager.class);

    SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmm");

    @Resource
    private MarketBaseDao marketBaseDao;

    @Resource
    private static  GroupDao groupDao;

    @Override
    public void run() {
        List<MarketBase> marketBaseList =  marketBaseDao.findAll();
        Date date = new Date();
        for (MarketBase marketBase:marketBaseList) {
            logger.warn(marketBase);
            Group group = groupDao.getCurrentGroup(marketBase.getMktId());
            if( group == null){
                createGroup(marketBase);
            }
            if(group.getEndTime().getTime() <= date.getTime()){
                createGroup(marketBase);
            }
        }
    }

    public Group createGroup(MarketBase marketBase){
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
