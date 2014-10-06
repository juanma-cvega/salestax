package com.mycompany.salestax.dao.mock;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.salestax.beans.ModelBean;
import com.mycompany.salestax.dao.AbstractDao;
import com.mycompany.salestax.util.ExceptionsLauncher;
import com.rits.cloning.Cloner;

public class AbstractDaoMock<T extends ModelBean<Long>, ID extends Serializable> implements AbstractDao<T, Long> {
	
	private List<T> listadoObjetosMock;
	
	private Class<T> clasePersistida;
	
	@SuppressWarnings("unchecked")
	public AbstractDaoMock() {
		this.listadoObjetosMock = new ArrayList<T>();
		this.clasePersistida = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			T newInstance = clasePersistida.newInstance();
			newInstance.setId(1L);
			listadoObjetosMock.add(newInstance);
		} catch (Exception e) {
			ExceptionsLauncher.launch(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public T create(T objetoParaGuardar) {
		objetoParaGuardar = crearNuevoIdParaObjeto(objetoParaGuardar);
		Cloner cloner = new Cloner();
		Object clonedObject = cloner.deepClone(objetoParaGuardar);
		anhadirdObjeto((T) clonedObject);
		return objetoParaGuardar;
	}
	
	private T crearNuevoIdParaObjeto(T objetoParaGuardar) {
		Long idNuevoObjeto = (long) (listadoObjetosMock.size() + 1);
		objetoParaGuardar.setId(idNuevoObjeto);
		return objetoParaGuardar;
	}
	
	public T read(Long identificador) {
		return getObjetoDelListado(identificador);
	}
	
	public void update(T objetoParaActualizar) {
		T objetoRecuperado = getObjetoDelListado(objetoParaActualizar.getId());
		delete(objetoRecuperado);
		anhadirdObjeto(objetoParaActualizar);
	}
	
	public void delete(T objetoParaBorrar) {
		delete(objetoParaBorrar.getId());
	}
	
	public void delete(Long identificadorObjeto) {
		T objetoEncontrado = null;
		for (T objeto : listadoObjetosMock) {
			if (objeto.getId() == identificadorObjeto) {
				objetoEncontrado = objeto;
			}
		}
		listadoObjetosMock.remove(objetoEncontrado);
	}
	
	public List<T> list() {
		List<T> copiaListadoMock = new ArrayList<T>(listadoObjetosMock);
		return copiaListadoMock;
	}
	
	@SuppressWarnings("unchecked")
	public T getObjetoDelListado(Long identificador) {
		T objetoEncontrado = null;
		for (T objeto : listadoObjetosMock) {
			if (objeto.getId() == identificador) {
				Cloner cloner = new Cloner();
				Object clonedObject = cloner.deepClone(objeto);
				objetoEncontrado = (T) clonedObject;
			}
		}
		return objetoEncontrado;
	}
	
	public void anhadirdObjeto(T objeto) {
		listadoObjetosMock.add(objeto);
	}
}
