package com.mycompany.salestax.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.mycompany.salestax.beans.ImportTax;
import com.mycompany.salestax.dao.ImportTaxDao;

@Repository(value = "importTaxDaoHibernate")
public class ImportTaxDaoHibernate extends AbstractDaoHibernate<ImportTax, Long> implements ImportTaxDao {
	
}
