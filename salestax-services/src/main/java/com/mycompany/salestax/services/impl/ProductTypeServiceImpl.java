package com.mycompany.salestax.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.salestax.beans.ProductType;
import com.mycompany.salestax.dao.ProductTypeDao;
import com.mycompany.salestax.services.ProductTypeService;

@Service("productTypeServiceImpl")
public class ProductTypeServiceImpl extends AbstractServiceImpl<ProductType, Long> implements ProductTypeService {
	
	@Resource(name = "productTypeDaoHibernate")
	public void setDao(ProductTypeDao productTypeDao) {
		this.dao = productTypeDao;
	}
}
