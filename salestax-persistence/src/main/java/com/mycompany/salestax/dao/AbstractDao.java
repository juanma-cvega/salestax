package com.mycompany.salestax.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.salestax.beans.ModelBean;

@Transactional
public interface AbstractDao<T extends ModelBean<ID>, ID extends Serializable> {
	
	T create(T object);
	
	T read(ID id);
	
	void update(T object);
	
	void delete(ID id);
	
	List<T> list();
}
