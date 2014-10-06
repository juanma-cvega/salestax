package com.mycompany.salestax.dao;

import junit.framework.Assert;

import com.mycompany.salestax.beans.ProductType;

public abstract class ProductTypeDaoTest extends AbstractDaoTest<ProductType> {
	
	@Override
	protected void hookDataCheck(ProductType productType) {
		Assert.assertNotNull(productType.getDescription());
		Assert.assertNotNull(productType.getTax());
	}
	
	@Override
	protected ProductType hookModificationOfObjectToUpdate(ProductType proofObject) {
		proofObject.setDescription("another description");
		return proofObject;
	}
}
