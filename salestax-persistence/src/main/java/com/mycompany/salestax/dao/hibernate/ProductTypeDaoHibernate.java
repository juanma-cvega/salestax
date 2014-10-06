package com.mycompany.salestax.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.mycompany.salestax.beans.ProductType;
import com.mycompany.salestax.dao.ProductTypeDao;

@Repository(value = "productTypeDaoHibernate")
public class ProductTypeDaoHibernate extends AbstractDaoHibernate<ProductType, Long> implements ProductTypeDao {
	
}
