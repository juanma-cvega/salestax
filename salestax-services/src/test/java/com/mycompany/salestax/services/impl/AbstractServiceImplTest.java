package com.mycompany.salestax.services.impl;

import java.lang.reflect.ParameterizedType;

import org.junit.Assert;
import org.junit.Test;

import com.mycompany.salestax.beans.ModelBean;
import com.mycompany.salestax.services.AbstractService;
import com.mycompany.salestax.util.MockBeanFactory;

public abstract class AbstractServiceImplTest<T extends ModelBean<Long>> {
	
	protected AbstractService<T, Long> service;
	private T testObject;
	private Class<T> persistedClass;
	
	@SuppressWarnings("unchecked")
	public AbstractServiceImplTest() {
		this.persistedClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Test
	public void testGuardar() {
		testSaveObject();
		testLoadObject();
		testUpdateObject();
		testRemoveObject();
	}
	
	private void testSaveObject() {
		T objectToSave = givenObjectToSave();
		testObject = whenObjectIsSaved(objectToSave);
		thenObjectHasId(objectToSave);
	}
	
	private void testLoadObject() {
		Long id = givenAnObjectId();
		T objectLoaded = whenObjectWithIdIsRetrieved(id);
		thenObjectIsLoaded(objectLoaded);
	}
	
	private void testUpdateObject() {
		T testObject = givenObjectToUpdate();
		whenObjectIsUpdated(testObject);
		thenObjectIsUpdatedOnDB(testObject);
	}
	
	private void testRemoveObject() {
		Long id = givenAnObjectIdToRemove();
		whenObjectIsDeleted(id);
		thenObjectIsNoLongerOnDB(id);
	}
	
	private T givenObjectToSave() {
		return MockBeanFactory.getMock(persistedClass);
	}
	
	private T whenObjectIsSaved(T objectToSave) {
		return service.save(objectToSave);
	}
	
	private void thenObjectHasId(T objectToSave) {
		Assert.assertNotNull(objectToSave);
		Assert.assertNotNull(objectToSave.getId());
	}
	
	private Long givenAnObjectId() {
		return testObject.getId();
	}
	
	private T whenObjectWithIdIsRetrieved(Long id) {
		return service.load(id);
	}
	
	private void thenObjectIsLoaded(T objectLoaded) {
		hookCheckLoadedObject(objectLoaded);
	}
	
	protected abstract void hookCheckLoadedObject(T objectLoaded);
	
	private T givenObjectToUpdate() {
		return hookTestObjectModification(testObject);
	}
	
	protected abstract T hookTestObjectModification(T testObject);
	
	private void whenObjectIsUpdated(T testObject) {
		service.update(testObject);
	}
	
	private void thenObjectIsUpdatedOnDB(T testObject) {
		T objectLoaded = service.load(testObject.getId());
		hookCheckUpdatedObject(testObject, objectLoaded);
	}
	
	protected abstract void hookCheckUpdatedObject(T objectToUpdate, T updatedObject);
	
	private Long givenAnObjectIdToRemove() {
		return testObject.getId();
	}
	
	private void whenObjectIsDeleted(Long id) {
		service.remove(id);
	}
	
	private void thenObjectIsNoLongerOnDB(Long id) {
		T objetoBorrado = service.load(id);
		Assert.assertNull(objetoBorrado);
	}
	
}
