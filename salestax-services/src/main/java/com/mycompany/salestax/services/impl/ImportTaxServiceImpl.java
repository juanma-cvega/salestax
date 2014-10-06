package com.mycompany.salestax.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.salestax.beans.ImportTax;
import com.mycompany.salestax.dao.ImportTaxDao;
import com.mycompany.salestax.services.ImportTaxService;

@Service("importTaxServiceImpl")
public class ImportTaxServiceImpl extends AbstractServiceImpl<ImportTax, Long> implements ImportTaxService {
	
	@Resource(name = "importTaxDaoHibernate")
	public void setDao(ImportTaxDao importTaxDao) {
		this.dao = importTaxDao;
	}
}
