package com.mycompany.salestax.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.mycompany.salestax.beans.Tax;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.dao.TaxDaoTest;
import com.mycompany.salestax.dao.constants.ContextPaths;

@ContextConfiguration(locations = ContextPaths.HIBERNATE_TEST_CONTEXT)
public class TaxDaoHibernateTest extends TaxDaoTest {
	
	@Resource(name = "taxDaoHibernate")
	@Override
	protected void setAbstractDao(AbstractDao<Tax, Long> productDao) {
		this.abstractDao = productDao;
	}
}
