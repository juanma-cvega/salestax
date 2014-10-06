package com.mycompany.salestax.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.salestax.beans.Product;
import com.mycompany.salestax.dao.ProductDao;
import com.mycompany.salestax.services.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl extends AbstractServiceImpl<Product, Long> implements ProductService {
	
	@Resource(name = "productDaoHibernate")
	public void setDao(ProductDao productDao) {
		this.dao = productDao;
	}
	
}
