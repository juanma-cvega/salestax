package com.mycompany.salestax.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "ImportTaxes")
public class ImportTax implements Serializable, ModelBean<Long> {
	
	private static final long serialVersionUID = -3015161145255023640L;
	private Long id;
	private BigDecimal value;
	private String description;
	
	public ImportTax() {
	}
	
	public ImportTax(String description) {
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "import_tax_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "import_tax_value", unique = true, nullable = false, precision = 20, scale = 2)
	public BigDecimal getValue() {
		return value;
	}
	
	public void setValue(BigDecimal value) {
		this.value = value;
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
		int hash = 6;
		
		hash = 24 * hash + ((getDescription() != null) ? getDescription().hashCode() : 0);
		hash = 24 * hash + ((getValue() != null) ? getValue().hashCode() : 0);
		
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ImportTax))
			return false;
		return (this.getDescription().equals(((ImportTax) object).getDescription())) ? true : false;
	}
}
