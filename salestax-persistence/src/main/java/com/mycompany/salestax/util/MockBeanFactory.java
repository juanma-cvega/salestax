package com.mycompany.salestax.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.mycompany.salestax.beans.ImportTax;
import com.mycompany.salestax.beans.ModelBean;
import com.mycompany.salestax.beans.Product;
import com.mycompany.salestax.beans.ProductType;
import com.mycompany.salestax.beans.Tax;

public abstract class MockBeanFactory {
	
	@SuppressWarnings("unchecked")
	public static <T extends ModelBean<Long>> T getMock(Class<T> beanClass) {
		
		if (beanClass.equals(Product.class)) {
			return (T) getProductMock();
		} else if (beanClass.equals(ProductType.class)) {
			return (T) getProductTypeMock();
		} else if (beanClass.equals(Tax.class)) {
			return (T) getTaxMock();
		} else if (beanClass.equals(ImportTax.class)) {
			return (T) getImportTaxMock();
		}
		return null;
	}
	
	public static <T extends ModelBean<Long>> List<T> getListMock(Class<T> beanClass, int length) {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < length; i++) {
			list.add(getMock(beanClass));
		}
		return list;
	}
	
	private static ImportTax getImportTaxMock() {
		ImportTax importTax = new ImportTax();
		importTax.setDescription("description" + getRandomValue());
		importTax.setValue(new BigDecimal(300));
		return importTax;
	}
	
	private static Tax getTaxMock() {
		Tax tax = new Tax();
		tax.setDescription("description" + getRandomValue());
		tax.setValue(new BigDecimal(200));
		return tax;
	}
	
	private static ProductType getProductTypeMock() {
		ProductType productType = new ProductType();
		productType.setDescription("description" + getRandomValue());
		productType.setTax((Tax) getTaxMock());
		productType.getTax().setId(1l);
		return productType;
	}
	
	private static Product getProductMock() {
		Product product = new Product();
		product.setDescription("description" + getRandomValue());
		product.setImportTax((ImportTax) getImportTaxMock());
		product.getImportTax().setId(1l);
		product.setPrice(new BigDecimal(100));
		product.setType((ProductType) getProductTypeMock());
		product.getType().setId(1l);
		return product;
	}
	
	private static String getRandomValue() {
		return RandomStringUtils.random(100);
	}
}
