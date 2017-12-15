package com.sf.bdp.marathon.dao.impl;

import com.sf.bdp.marathon.dao.GroupDao;
import com.sf.bdp.marathon.entity.Group;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * 集货团用户关系表dao接口实现类
 *
 * @author 01368020
 */
@Repository
public class GroupDaoImpl extends BaseDaoImpl<Group, String> implements GroupDao {

    @Override
    public Group getCurrentGroup(String mktId) {
        String sql = "select * from pro_group where mkt_id = ? order by end_time desc limit 1";
        Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
        query.setParameter(0, mktId);
        return (Group) query.uniqueResult();
    }
}
