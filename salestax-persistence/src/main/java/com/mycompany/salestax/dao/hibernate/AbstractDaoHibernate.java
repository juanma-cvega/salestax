package com.mycompany.salestax.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.salestax.beans.ModelBean;
import com.mycompany.salestax.dao.AbstractDao;

public abstract class AbstractDaoHibernate<T extends ModelBean<ID>, ID extends Serializable> implements AbstractDao<T, ID> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> persistedClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDaoHibernate() {
		this.persistedClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T create(T object) {
		getSession().saveOrUpdate(object);
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public T read(ID id) {
		return (T) getSession().get(persistedClass, id);
	}
	
	public void update(T object) {
		getSession().update(object);
	}
	
	public void delete(ID id) {
		T sessionObject = read(id);
		getSession().delete(sessionObject);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list() {
		return getSession().createCriteria(persistedClass).list();
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
