package com.mycompany.salestax.dao;

import junit.framework.Assert;

import com.mycompany.salestax.beans.Tax;

public abstract class TaxDaoTest extends AbstractDaoTest<Tax> {
	
	@Override
	protected void hookDataCheck(Tax product) {
		Assert.assertNotNull(product.getDescription());
		Assert.assertNotNull(product.getValue());
	}
	
	@Override
	protected Tax hookModificationOfObjectToUpdate(Tax proofObject) {
		proofObject.setDescription("another description");
		return proofObject;
	}
}
