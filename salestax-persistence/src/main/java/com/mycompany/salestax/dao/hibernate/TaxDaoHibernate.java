package com.mycompany.salestax.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.mycompany.salestax.beans.Tax;
import com.mycompany.salestax.dao.TaxDao;

@Repository(value = "taxDaoHibernate")
public class TaxDaoHibernate extends AbstractDaoHibernate<Tax, Long> implements TaxDao {
	
}
