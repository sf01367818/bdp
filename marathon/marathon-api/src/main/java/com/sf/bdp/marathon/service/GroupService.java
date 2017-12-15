package com.sf.bdp.marathon.service;

import com.sf.bdp.marathon.entity.Group;

/**
 * 集货团Service
 *
 * @author
 */
public interface GroupService {

    /**
     * get a group
     *
     * @param groupId
     * @return
     */
    Group getGroup(String groupId);


    /**
     * get the current group
     *
     * @param mktId
     * @return
     */
    Group getCurrentGroup(String mktId);

    /**
     * create a new group
     *
     * @param mktId
     * @return
     */
    Group createGroup(String mktId);


	void save(Group group);
}
