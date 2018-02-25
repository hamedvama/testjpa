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


import domain.ElectroDevice;
import istic.fr.dao.daoGeneric.DeviceDao;


public class ElectroDaoImpl implements DeviceDao {
	

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	EntityManager manager = factory.createEntityManager();

	EntityTransaction transaction = manager.getTransaction();
	
	
	// PERSIST DEVICE

	public void Ajouter(ElectroDevice electro) {
		
		transaction.begin();
		try {
		 manager.persist(electro);
		 transaction.commit();	
		}
		catch(Exception e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}}
	

	
	// GET DEVICES LIST WITH CRITERIA API

	
	public List<ElectroDevice> getAll() {
		CriteriaBuilder builder=manager.getCriteriaBuilder();
		CriteriaQuery<ElectroDevice> query=builder.createQuery(ElectroDevice.class);
		Root<ElectroDevice>ElectroRoot=query.from(ElectroDevice.class);
		query.select(ElectroRoot);
	    TypedQuery<ElectroDevice> quer =manager.createQuery(query);
	    List<ElectroDevice> electronics=quer.getResultList();
        return electronics; }
	
	
	// FIND DEVICE BY ID
	
	public ElectroDevice findOne(int id) {
	   return manager.find(ElectroDevice.class, id);
		
        }

	}



	
    



