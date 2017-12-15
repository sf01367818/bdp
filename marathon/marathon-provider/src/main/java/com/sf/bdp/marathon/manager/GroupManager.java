package com.sf.bdp.marathon.manager;

import com.sf.bdp.marathon.entity.Group;
import com.sf.bdp.marathon.entity.MarketBase;
import com.sf.bdp.marathon.service.GroupService;
import com.sf.bdp.marathon.service.MarketBaseService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class GroupManager implements Runnable {

    private static final Logger logger = Logger.getLogger(GroupManager.class);

    SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmm");

    @Resource
    private MarketBaseService marketBaseService;

    @Resource
    private GroupService groupService;

    @Override
    public void run() {
        List<MarketBase> marketBaseList =  marketBaseService.findAll();
        Date date = new Date();
        for (MarketBase marketBase:marketBaseList) {
            logger.warn(marketBase);
            Group group = groupService.getCurrentGroup(marketBase.getMktId());
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
        groupService.save(group);
        return group;
    }
}
