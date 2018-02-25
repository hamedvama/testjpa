package istic.fr.dao.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import domain.Heater;
import istic.fr.dao.daoGeneric.HeaterDao;


public class HeaterDaoImpl implements HeaterDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	EntityManager manager = factory.createEntityManager();
     EntityTransaction transaction = manager.getTransaction();
	
 	// PERSIST HEATER

	public void Ajouter(Heater heater) {
		
		transaction.begin();
		try {
		 manager.persist(heater);
		 transaction.commit();	
		}
		catch(Exception e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}}
	
	
	// GET HEATERS LIST WITH CRITERIA API

	
	public List<Heater> getAll() {
		
		CriteriaBuilder builder=manager.getCriteriaBuilder();
		CriteriaQuery<Heater> query=builder.createQuery(Heater.class);
		Root<Heater>heaterRoot=query.from(Heater.class);
		query.select(heaterRoot);
	    TypedQuery<Heater>quer=manager.createQuery(query);
	    
		List<Heater> heaters=quer.getResultList();
        return heaters;   }
	
	
	// FIND HEATER BY ID
	public Heater findOne(int id) {
	  return manager.find(Heater.class, id);
	}

	





	






}
