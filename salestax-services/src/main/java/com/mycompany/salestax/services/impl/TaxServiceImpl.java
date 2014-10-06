package com.mycompany.salestax.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.salestax.beans.Tax;
import com.mycompany.salestax.dao.TaxDao;
import com.mycompany.salestax.services.TaxService;

@Service("taxServiceImpl")
public class TaxServiceImpl extends AbstractServiceImpl<Tax, Long> implements TaxService {
	
	@Resource(name = "taxDaoHibernate")
	public void setDao(TaxDao taxDao) {
		this.dao = taxDao;
	}
}
