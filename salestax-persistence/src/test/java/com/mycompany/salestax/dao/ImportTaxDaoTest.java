package com.mycompany.salestax.dao;

import junit.framework.Assert;

import com.mycompany.salestax.beans.ImportTax;

public abstract class ImportTaxDaoTest extends AbstractDaoTest<ImportTax> {
	
	@Override
	protected void hookDataCheck(ImportTax importTax) {
		Assert.assertNotNull(importTax.getDescription());
		Assert.assertNotNull(importTax.getValue());
	}
	
	@Override
	protected ImportTax hookModificationOfObjectToUpdate(ImportTax proofObject) {
		proofObject.setDescription("another description");
		return proofObject;
	}
}
