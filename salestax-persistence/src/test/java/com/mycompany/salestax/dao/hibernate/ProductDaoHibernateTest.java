package com.mycompany.salestax.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.mycompany.salestax.beans.Product;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.dao.ProductDaoTest;
import com.mycompany.salestax.dao.constants.ContextPaths;

@ContextConfiguration(locations = ContextPaths.HIBERNATE_TEST_CONTEXT)
public class ProductDaoHibernateTest extends ProductDaoTest {
	
	@Resource(name = "productDaoHibernate")
	@Override
	protected void setAbstractDao(AbstractDao<Product, Long> productDao) {
		this.abstractDao = productDao;
	}
}
