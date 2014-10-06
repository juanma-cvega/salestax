package com.mycompany.salestax.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.salestax.beans.ModelBean;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.services.AbstractService;

@Transactional
public abstract class AbstractServiceImpl<T extends ModelBean<ID>, ID extends Serializable> implements AbstractService<T, ID> {
	
	protected AbstractDao<T, ID> dao;
	
	public T save(T objectToSave) {
		return dao.create(objectToSave);
	}
	
	public T load(ID id) {
		return dao.read(id);
	}
	
	public void update(T objectToUdpate) {
		dao.update(objectToUdpate);
	}
	
	public void remove(ID id) {
		dao.delete(id);
	}
	
	public List<T> list() {
		return dao.list();
	}
}
