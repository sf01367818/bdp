package com.sf.bdp.marathon.dao.impl;

import java.io.Serializable;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

public class BaseDaoImpl<T, K extends Serializable> extends GenericDAOImpl<T, K>{
	
	@Resource(name="sessionFactory")
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
