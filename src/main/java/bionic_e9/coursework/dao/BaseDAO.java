package bionic_e9.coursework.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.*;

public class BaseDAO {
	protected static final String UNIT_NAME = "flights";
	protected static EntityManagerFactory factory;
	protected static EntityManager entityManager;
	
	static {
		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		entityManager = factory.createEntityManager();
	}
	
	public static Date str2date(String date) {
		java.sql.Date dt = null;
		
		try {
			dt = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(date).getTime());
		} catch (Exception e) {
		}
		
		return dt;
	}
	
	public static <T> T find(Class<T> entityClass, int id) {
		Object entity = null;
		
		try {
			entity = entityManager.find(entityClass, id);
		} finally {
			entityManager.close();
		}
		
		return entityClass.cast(entity);
	}
	
	public static <T> T save(final T entity) {
		entityManager.getTransaction().begin();
		
	    if (!entityManager.contains(entity)) {
	        // persist object - add to entity manager
	    	entityManager.persist(entity);
	        // flush entityManager - save to DB
	    	entityManager.flush();
	    }
	    
	    // commit transaction at all
	    entityManager.getTransaction().commit();
	    
		return entity;
	}
	
	public static <T> List<T> query(Class<T> entityClass, String query) {
		TypedQuery<T> q = entityManager.createQuery(query, entityClass);
		List<T> entities = null;
		
		try { 
			entities = q.getResultList(); 
		} finally { 
			entityManager.close();
		}
		
		return entities;
	}
}
