package com.mycompany.salestax.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "ProductTypes")
public class ProductType implements Serializable, ModelBean<Long> {
	
	private static final long serialVersionUID = 996573697841111581L;
	private Long id;
	private Tax tax;
	private String description;
	
	public ProductType() {
	}
	
	public ProductType(String description) {
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_type_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tax", nullable = false)
	public Tax getTax() {
		return tax;
	}
	
	public void setTax(Tax tax) {
		this.tax = tax;
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
		
		hash = 47 * hash + ((getDescription() != null) ? getDescription().hashCode() : 0);
		hash = 47 * hash + ((getTax() != null) ? getTax().hashCode() : 0);
		
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ProductType))
			return false;
		return (this.getDescription().equals(((ProductType) object).getDescription())) ? true : false;
	}
}
