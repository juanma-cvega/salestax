package com.mycompany.salestax.services.impl;

import org.junit.Assert;
import org.springframework.test.util.ReflectionTestUtils;

import com.mycompany.salestax.beans.Tax;
import com.mycompany.salestax.dao.mock.TaxDaoMock;
import com.mycompany.salestax.services.TaxService;

public class TaxServiceImplTest extends AbstractServiceImplTest<Tax> {
	
	public TaxServiceImplTest() {
		super();
		TaxService mockService = new TaxServiceImpl();
		ReflectionTestUtils.setField(mockService, "dao", new TaxDaoMock());
		this.service = mockService;
	}
	
	@Override
	protected void hookCheckLoadedObject(Tax tax) {
		Assert.assertNotNull(tax.getDescription());
		Assert.assertNotNull(tax.getValue());
		Assert.assertNotNull(tax.getId());
	}
	
	@Override
	protected Tax hookTestObjectModification(Tax tax) {
		tax.setDescription("another description");
		return tax;
	}
	
	@Override
	protected void hookCheckUpdatedObject(Tax objectToUpdate, Tax objectUpdated) {
		Assert.assertEquals(objectToUpdate.getDescription(), objectUpdated.getDescription());
	}
}
