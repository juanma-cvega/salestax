package com.mycompany.salestax.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.mycompany.salestax.beans.ProductType;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.dao.ProductTypeDaoTest;
import com.mycompany.salestax.dao.constants.ContextPaths;

@ContextConfiguration(locations = ContextPaths.HIBERNATE_TEST_CONTEXT)
public class ProductTypeDaoHibernateTest extends ProductTypeDaoTest {
	
	@Resource(name = "productTypeDaoHibernate")
	@Override
	protected void setAbstractDao(AbstractDao<ProductType, Long> productTypeDao) {
		this.abstractDao = productTypeDao;
	}
}
