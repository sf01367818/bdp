package com.sf.bdp.marathon.service;

import java.util.List;

import com.sf.bdp.marathon.entity.MarketBase;

/**
 * 专业市场Service
 *
 * @author
 */
public interface MarketBaseService {
    /**
     * get mark info
     *
     * @param mktId
     * @return
     */
    MarketBase getMarkBase(String mktId);
    
    List<MarketBase> findAll();

}
