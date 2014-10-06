package com.mycompany.salestax.services.impl;

import org.junit.Assert;
import org.springframework.test.util.ReflectionTestUtils;

import com.mycompany.salestax.beans.ProductType;
import com.mycompany.salestax.dao.mock.ProductTypeDaoMock;
import com.mycompany.salestax.services.ProductTypeService;

public class ProductTypeServiceImplTest extends AbstractServiceImplTest<ProductType> {
	
	public ProductTypeServiceImplTest() {
		super();
		ProductTypeService mockService = new ProductTypeServiceImpl();
		ReflectionTestUtils.setField(mockService, "dao", new ProductTypeDaoMock());
		this.service = mockService;
	}
	
	@Override
	protected void hookCheckLoadedObject(ProductType productType) {
		Assert.assertNotNull(productType.getDescription());
		Assert.assertNotNull(productType.getTax());
		Assert.assertNotNull(productType.getId());
	}
	
	@Override
	protected ProductType hookTestObjectModification(ProductType productType) {
		productType.setDescription("another description");
		return productType;
	}
	
	@Override
	protected void hookCheckUpdatedObject(ProductType objectToUpdate, ProductType objectUpdated) {
		Assert.assertEquals(objectToUpdate.getDescription(), objectUpdated.getDescription());
	}
	
}
