package com.mycompany.salestax.dao.mock;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.mycompany.salestax.beans.ProductType;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.dao.ProductTypeDaoTest;
import com.mycompany.salestax.dao.constants.ContextPaths;

@ContextConfiguration(locations = ContextPaths.MOCK_TEST_CONTEXT)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class ProductTypeDaoMockTest extends ProductTypeDaoTest {
	
	@Resource(name = "productTypeDaoMock")
	@Override
	protected void setAbstractDao(AbstractDao<ProductType, Long> productTypeDao) {
		this.abstractDao = productTypeDao;
	}
}
