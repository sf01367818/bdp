package com.sf.bdp.marathon.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.sf.bdp.marathon.entity.Group;

/**
 * 集货团用户关系表dao接口
 *
 * @author 01368020
 */
public interface GroupDao extends GenericDAO<Group, String> {
    /**
     * 获取专业市场最新的组团
     *
     * @param mktId
     * @return
     * @author 01367818
     */
    public Group getCurrentGroup  (String mktId);

}
