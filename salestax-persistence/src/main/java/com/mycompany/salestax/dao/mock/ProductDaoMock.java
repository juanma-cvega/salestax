package com.mycompany.salestax.dao.mock;

import org.springframework.stereotype.Repository;

import com.mycompany.salestax.beans.Product;
import com.mycompany.salestax.dao.ProductDao;

@Repository(value = "productDaoMock")
public class ProductDaoMock extends AbstractDaoMock<Product, Long> implements ProductDao {
	
}
