package com.mycompany.salestax.dao.mock;

import org.springframework.stereotype.Repository;

import com.mycompany.salestax.beans.Tax;
import com.mycompany.salestax.dao.TaxDao;

@Repository(value = "taxDaoMock")
public class TaxDaoMock extends AbstractDaoMock<Tax, Long> implements TaxDao {
	
}
