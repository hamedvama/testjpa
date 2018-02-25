package istic.fr.dao.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import domain.Person;
import istic.fr.dao.daoGeneric.PersonDao;

public class PersonDaoImpl  implements PersonDao{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	EntityManager manager = factory.createEntityManager();

	EntityTransaction transaction = manager.getTransaction();

// PERSIST PERSON
	public void Ajouter(Person person) {
		
		transaction.begin();
		try {
		 manager.persist(person);
		 transaction.commit();	
		}
		catch(Exception e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}}
	
	//GET PERSONS LIST WITH HQL

	public List<Person> getAll() {
		List<Person> persons= manager.createQuery("Select p From Person p",Person.class).getResultList();
        return persons; 
        }
	

	//FIND PERSON BY ID
	public Person findOne(int id) {
		
		return manager.find(Person.class, id);
	}

	

	

}
