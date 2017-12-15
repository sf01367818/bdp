package com.sf.bdp.marathon.service;

import com.sf.bdp.marathon.dao.MarketBaseDao;
import com.sf.bdp.marathon.entity.MarketBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * 集货团用户关系表Service实现类
 *
 * @author 01368020
 */
@Service("marketBaseService")
@Transactional(rollbackFor = Exception.class)
public class MarketBaseServiceImpl implements MarketBaseService {

  @Resource
  private MarketBaseDao marketBaseDao;

  @Override
  public MarketBase getMarkBase(String mktId) {
    return marketBaseDao.find(mktId);
  }

@Override
public List<MarketBase> findAll() {
	return marketBaseDao.findAll();
}
  
}
