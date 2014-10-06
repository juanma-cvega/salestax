package com.mycompany.salestax.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.salestax.beans.ModelBean;
import com.mycompany.salestax.util.MockBeanFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class AbstractDaoTest<T extends ModelBean<Long>> {
	
	protected AbstractDao<T, Long> abstractDao;
	private T testObject;
	private Class<T> persistedClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDaoTest() {
		this.persistedClass = (Class<T>) ((ParameterizedType) ((Class<T>) (getClass().getGenericSuperclass())).getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Test
	public void testCrud() {
		creationTest();
		readTest();
		updateTest();
		deleteTest();
	}
	
	@Test
	public void testList() {
		int length = 2;
		List<T> listMock = givenListObjectsToCreate(length);
		whenListIsCreated(listMock);
		thenDBHasSameNumberOfElementsAtLeast(length);
	}
	
	private List<T> givenListObjectsToCreate(int length) {
		return MockBeanFactory.getListMock(persistedClass, 2);
	}
	
	private void whenListIsCreated(List<T> list) {
		for (T object : list) {
			T castedObject = (T) object;
			abstractDao.create(castedObject);
		}
	}
	
	private void thenDBHasSameNumberOfElementsAtLeast(int length) {
		List<T> createdList = abstractDao.list();
		Assert.assertTrue(createdList.size() >= length);
	}
	
	private void creationTest() {
		T object = givenObjectWithoutId();
		testObject = whenObjectIsCreated(object);
		thenObjectHasId(testObject);
	}
	
	private T givenObjectWithoutId() {
		T mockBean = MockBeanFactory.getMock(persistedClass);
		mockBean.setId(null);
		return mockBean;
	}
	
	private T whenObjectIsCreated(T objectToSave) {
		objectToSave = abstractDao.create(objectToSave);
		return objectToSave;
	}
	
	private void thenObjectHasId(T createdObject) {
		Assert.assertNotNull(createdObject);
		Assert.assertNotNull(createdObject.getId());
	}
	
	private void readTest() {
		Long id = givenAnId();
		T readObject = whenReadObjectFromDB(id);
		thenObjectHasData(readObject);
	}
	
	private Long givenAnId() {
		return testObject.getId();
	}
	
	private T whenReadObjectFromDB(Long id) {
		T readObject = abstractDao.read(id);
		return readObject;
	}
	
	private void thenObjectHasData(T objetoRecuperado) {
		hookDataCheck(objetoRecuperado);
	}
	
	abstract protected void hookDataCheck(T objetoRecuperado);
	
	private void updateTest() {
		T objectToUpdate = givenObjectToUpdate();
		whenDataIsUpdated(objectToUpdate);
		thenDataIsUpdated(objectToUpdate);
	}
	
	private T givenObjectToUpdate() {
		return hookModificationOfObjectToUpdate(testObject);
	}
	
	abstract protected T hookModificationOfObjectToUpdate(T proofObject);
	
	private void whenDataIsUpdated(T objectToUpdate) {
		abstractDao.update(objectToUpdate);
	}
	
	private void thenDataIsUpdated(T objectToUpdate) {
		T updatedObject = abstractDao.read(objectToUpdate.getId());
		Assert.assertEquals(objectToUpdate, updatedObject);
	}
	
	private void deleteTest() {
		T object = givenObjectWithId();
		whenObjectIsDeleted(object.getId());
		thenObjectIsNoLongerOnDB(object);
	}
	
	private T givenObjectWithId() {
		return testObject;
	}
	
	private void whenObjectIsDeleted(Long id) {
		abstractDao.delete(id);
	}
	
	private void thenObjectIsNoLongerOnDB(T object) {
		T deletedObject = abstractDao.read(object.getId());
		Assert.assertNull(deletedObject);
	}
	
	protected void setAbstractDao(AbstractDao<T, Long> abstractDao) {
		this.abstractDao = abstractDao;
	}
}
