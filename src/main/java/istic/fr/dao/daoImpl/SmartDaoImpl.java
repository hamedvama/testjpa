package istic.fr.dao.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.SmartDevices;
import istic.fr.dao.daoGeneric.SmartDao;

public class SmartDaoImpl implements SmartDao{
	

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	EntityManager manager = factory.createEntityManager();

	EntityTransaction transaction = manager.getTransaction();
	
   
	//PERSIST SMARTDEVICE
	
	public void Ajouter(SmartDevices smart) {
		
		transaction.begin();
		try {
		 manager.persist(smart);
		 transaction.commit();	
		}
		catch(Exception e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}}
		
   // GET SMARTDEVICES LIST WITH HQL

	public List<SmartDevices> getAll() {
		List<SmartDevices> Devices= manager.createQuery("Select s From SmartDevices s",SmartDevices.class).getResultList();
        return Devices; 
	}

	//FIND SMARTDEVICE WITH HQL
	
	public SmartDevices findOne(int id) {
	 return manager.find(SmartDevices.class, id);

	}

	




}
