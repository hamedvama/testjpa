package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Person;

public class JpaTest {

	private EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager managerr = factory.createEntityManager();
		JpaTest test = new JpaTest(managerr);
		
		EntityTransaction tx = managerr.getTransaction();
		tx.begin();
		try {
			test.createPerson();
			test.listPerson();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		managerr.close();
		factory.close();
	}
	
	private void createPerson() {
		
		int NbrEnrgPerson = manager.createQuery("SELECT a From Person a",Person.class).getResultList().size();
		
		if(NbrEnrgPerson<=10) {
			Person vama = new Person("Diakite","Hamed","hamed@gmail.fr"); 
			Person gatien = new Person("Anoh","abbah","abbah@yahoo.fr");
			vama.addfriend(gatien);
			manager.persist(vama);
			manager.persist(gatien);
		}
	}
	
	private void listPerson() {
//		String s = "SELECT e FROM Person as e where e.name=:name";
//		Query q = manager.createQuery(s,Person.class);
//		q.setParameter("name", "Diakite");
//		
//		List<Person> res = q.getResultList();
		
		List<Person> listp = manager.createQuery("SELECT e FROM Person as e",Person.class).getResultList();

		System.out.println(listp.size());
		for(Person person : listp) {
			System.out.println(person.toString());
		}
	}

}
