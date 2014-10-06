package com.mycompany.salestax.services.impl;

import org.junit.Assert;
import org.springframework.test.util.ReflectionTestUtils;

import com.mycompany.salestax.beans.ImportTax;
import com.mycompany.salestax.dao.mock.ProductDaoMock;
import com.mycompany.salestax.services.ImportTaxService;

public class ImportTaxServiceImplTest extends AbstractServiceImplTest<ImportTax> {
	
	public ImportTaxServiceImplTest() {
		super();
		ImportTaxService mockService = new ImportTaxServiceImpl();
		ReflectionTestUtils.setField(mockService, "dao", new ProductDaoMock());
		this.service = mockService;
	}
	
	@Override
	protected void hookCheckLoadedObject(ImportTax importTax) {
		Assert.assertNotNull(importTax.getDescription());
		Assert.assertNotNull(importTax.getValue());
		Assert.assertNotNull(importTax.getId());
	}
	
	@Override
	protected ImportTax hookTestObjectModification(ImportTax importTax) {
		importTax.setDescription("another description");
		return importTax;
	}
	
	@Override
	protected void hookCheckUpdatedObject(ImportTax objectToUpdate, ImportTax objectUpdated) {
		Assert.assertEquals(objectToUpdate.getDescription(), objectUpdated.getDescription());
	}
}
