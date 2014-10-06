package com.mycompany.salestax.beans;

import java.io.Serializable;

public interface ModelBean<ID extends Serializable> {
	
	ID getId();
	
	void setId(ID id);
}
