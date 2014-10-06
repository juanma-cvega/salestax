package com.mycompany.salestax.dao.hibernate;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.mycompany.salestax.beans.ImportTax;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.dao.ImportTaxDaoTest;
import com.mycompany.salestax.dao.constants.ContextPaths;

@ContextConfiguration(locations = ContextPaths.HIBERNATE_TEST_CONTEXT)
public class ImportTaxDaoHibernateTest extends ImportTaxDaoTest {
	
	@Resource(name = "importTaxDaoHibernate")
	@Override
	protected void setAbstractDao(AbstractDao<ImportTax, Long> importTaxDao) {
		this.abstractDao = importTaxDao;
	}
}
