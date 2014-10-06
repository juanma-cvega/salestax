package com.mycompany.salestax.dao;

import junit.framework.Assert;

import com.mycompany.salestax.beans.Product;

public abstract class ProductDaoTest extends AbstractDaoTest<Product> {
	
	@Override
	protected void hookDataCheck(Product product) {
		Assert.assertNotNull(product.getDescription());
		Assert.assertNotNull(product.getImportTax());
		Assert.assertNotNull(product.getPrice());
		Assert.assertNotNull(product.getType());
	}
	
	@Override
	protected Product hookModificationOfObjectToUpdate(Product proofObject) {
		proofObject.setDescription("another description");
		return proofObject;
	}
	
}
