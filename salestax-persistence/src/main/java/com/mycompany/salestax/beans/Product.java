package com.mycompany.salestax.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "Products")
public class Product implements Serializable, ModelBean<Long> {
	
	private static final long serialVersionUID = -5819554310487125941L;
	private Long id;
	private ProductType type;
	private ImportTax importTax;
	private BigDecimal price;
	private String description;
	
	public Product() {
	}
	
	public Product(String description) {
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	@Transient
	public Long getProductId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_type", nullable = false)
	public ProductType getType() {
		return type;
	}
	
	public void setType(ProductType type) {
		this.type = type;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "import_tax", nullable = false)
	public ImportTax getImportTax() {
		return importTax;
	}
	
	public void setImportTax(ImportTax importTax) {
		this.importTax = importTax;
	}
	
	@Column(name = "price", unique = true, nullable = false, precision = 20, scale = 2)
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Column(name = "description", unique = true, nullable = false, length = 255)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		
		hash = 11 * hash + ((getDescription() != null) ? getDescription().hashCode() : 0);
		
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Product))
			return false;
		return (this.getDescription().equals(((Product) object).getDescription())) ? true : false;
	}
}
