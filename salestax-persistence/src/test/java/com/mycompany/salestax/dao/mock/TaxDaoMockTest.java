package com.mycompany.salestax.dao.mock;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.mycompany.salestax.beans.Tax;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.dao.TaxDaoTest;
import com.mycompany.salestax.dao.constants.ContextPaths;

@ContextConfiguration(locations = ContextPaths.MOCK_TEST_CONTEXT)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class TaxDaoMockTest extends TaxDaoTest {
	
	@Resource(name = "taxDaoMock")
	@Override
	protected void setAbstractDao(AbstractDao<Tax, Long> taxDao) {
		this.abstractDao = taxDao;
	}
	
}
