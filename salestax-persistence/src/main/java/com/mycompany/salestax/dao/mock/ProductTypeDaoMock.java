package com.mycompany.salestax.dao.mock;

import org.springframework.stereotype.Repository;

import com.mycompany.salestax.beans.ProductType;
import com.mycompany.salestax.dao.ProductTypeDao;

@Repository(value = "productTypeDaoMock")
public class ProductTypeDaoMock extends AbstractDaoMock<ProductType, Long> implements ProductTypeDao {
	
}
