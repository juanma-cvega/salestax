package com.mycompany.salestax.services.impl;

import org.junit.Assert;
import org.springframework.test.util.ReflectionTestUtils;

import com.mycompany.salestax.beans.Product;
import com.mycompany.salestax.dao.mock.ProductDaoMock;
import com.mycompany.salestax.services.ProductService;

public class ProductServiceImplTest extends AbstractServiceImplTest<Product> {
	
	public ProductServiceImplTest() {
		super();
		ProductService mockService = new ProductServiceImpl();
		ReflectionTestUtils.setField(mockService, "dao", new ProductDaoMock());
		this.service = mockService;
	}
	
	@Override
	protected void hookCheckLoadedObject(Product product) {
		Assert.assertNotNull(product.getDescription());
		Assert.assertNotNull(product.getImportTax());
		Assert.assertNotNull(product.getPrice());
		Assert.assertNotNull(product.getType());
		Assert.assertNotNull(product.getId());
	}
	
	@Override
	protected Product hookTestObjectModification(Product product) {
		product.setDescription("another description");
		return product;
	}
	
	@Override
	protected void hookCheckUpdatedObject(Product objectToUpdate, Product objectUpdated) {
		Assert.assertEquals(objectToUpdate.getDescription(), objectUpdated.getDescription());
	}
	
}
