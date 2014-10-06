package com.mycompany.salestax.dao.mock;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.mycompany.salestax.beans.Product;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.dao.ProductDaoTest;
import com.mycompany.salestax.dao.constants.ContextPaths;

@ContextConfiguration(locations = ContextPaths.MOCK_TEST_CONTEXT)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class ProductDaoMockTest extends ProductDaoTest {
	
	@Resource(name = "productDaoMock")
	@Override
	protected void setAbstractDao(AbstractDao<Product, Long> productDao) {
		this.abstractDao = productDao;
	}
	
}
