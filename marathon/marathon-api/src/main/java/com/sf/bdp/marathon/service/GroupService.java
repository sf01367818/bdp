package com.sf.bdp.marathon.service;

import com.sf.bdp.marathon.entity.Group;

/**
 * 集货团Service
 *
 * @author
 */
public interface GroupService {

    /**
     * create a new group
     *
     * @param groupId
     * @return
     */
    Group getGroup(String groupId);


    /**
     * create a new group
     *
     * @param mktId
     * @return
     */
    Group getCurrentGroup(String mktId);

}
