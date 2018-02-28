package istic.fr.dao.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import istic.fr.dao.daoGeneric.PersonDao;
import domain.Person;

public class PersonDaoImpl implements PersonDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	/**
	 * Persist person in the database
	 * 
	 * @param person
	 *            person to persist
	 */
	public void Ajouter(Person person) {

		transaction.begin();
		try {
			manager.persist(person);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Get person list using hsql
	 * 
	 * @return persons
	 * 
	 */

	public List<Person> getAll() {
		List<Person> persons = manager.createQuery("Select p From Person p", Person.class).getResultList();
		return persons;
	}

	/**
	 * Find person by Id
	 * 
	 * @param id
	 *            id of person to find
	 * @return Person
	 * 
	 */
	public Person findOne(int id) {

		Person p = manager.find(Person.class, id);
		System.err.println(p.toString());
		return p;
	}

	/**
	 * @param id
	 *            id of person to update
	 */
	public void updatePerson(Person person) {
		// Person p = manager.find(Person.class, id);
		// if(!nom.equals("")) { p.setName(nom);}
		// if(!prenom.equals("")) {p.setFirstname(prenom);}
		// if(!mail.equals("")) {p.setEmail(mail);}
		// p.setFirstname("dudu");

		manager.merge(person);
	}

	/**
	 * @param id
	 *            id of person to delete
	 */
	public void deletePerson(int id) {
		Person p = manager.find(Person.class, id);
		manager.remove(p);
		System.err.println("dans le DAOimpl id: " + id);
	}

}
