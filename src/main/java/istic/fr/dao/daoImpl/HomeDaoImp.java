package istic.fr.dao.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Home;
import istic.fr.dao.daoGeneric.HomeDao;

public class HomeDaoImp  implements HomeDao{


	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	EntityManager manager = factory.createEntityManager();

	EntityTransaction transaction = manager.getTransaction();
	
	// PERSIST HOME

	public void Ajouter(Home home) {
		
		transaction.begin();
		try {
		 manager.persist(home);
		 transaction.commit();	
		}
		catch(Exception e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}}
	
	//GET HOMES LIST WITH HQL
	

	public List<Home> getAll() {
		List<Home> listhomes = manager.createNamedQuery("findAllHome").getResultList();
        return listhomes ; 
        }
	
	
	//FIND HOME BY ID

	public Home findOne(int id) {
	  return manager.find(Home.class, id);
	}


}
