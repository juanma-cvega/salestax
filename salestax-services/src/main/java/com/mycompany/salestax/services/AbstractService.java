package com.mycompany.salestax.services;

import java.io.Serializable;
import java.util.List;

import com.mycompany.salestax.beans.ModelBean;

public interface AbstractService<T extends ModelBean<ID>, ID extends Serializable> {
	
	T save(T objetoParaGuardar);
	
	T load(ID identificador);
	
	void update(T objetoParaActualizar);
	
	void remove(ID identificadorObjeto);
	
	List<T> list();
}
