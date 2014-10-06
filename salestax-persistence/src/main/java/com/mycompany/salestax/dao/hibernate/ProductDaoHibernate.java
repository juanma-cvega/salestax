package com.mycompany.salestax.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.mycompany.salestax.beans.Product;
import com.mycompany.salestax.dao.ProductDao;

@Repository(value = "productDaoHibernate")
public class ProductDaoHibernate extends AbstractDaoHibernate<Product, Long> implements ProductDao {
	
}
