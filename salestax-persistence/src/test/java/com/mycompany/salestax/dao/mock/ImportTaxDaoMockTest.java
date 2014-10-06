package com.mycompany.salestax.dao.mock;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.mycompany.salestax.beans.ImportTax;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.dao.ImportTaxDaoTest;
import com.mycompany.salestax.dao.constants.ContextPaths;

@ContextConfiguration(locations = ContextPaths.MOCK_TEST_CONTEXT)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class ImportTaxDaoMockTest extends ImportTaxDaoTest {
	
	@Resource(name = "importTaxDaoMock")
	@Override
	protected void setAbstractDao(AbstractDao<ImportTax, Long> importTaxDao) {
		this.abstractDao = importTaxDao;
	}
	
}