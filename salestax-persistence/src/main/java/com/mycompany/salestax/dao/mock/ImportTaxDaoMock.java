package com.mycompany.salestax.dao.mock;

import org.springframework.stereotype.Repository;

import com.mycompany.salestax.beans.ImportTax;
import com.mycompany.salestax.dao.ImportTaxDao;

@Repository(value = "importTaxDaoMock")
public class ImportTaxDaoMock extends AbstractDaoMock<ImportTax, Long> implements ImportTaxDao {
	
}
