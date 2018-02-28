package jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import domain.*;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager managerr = factory.createEntityManager();
		JpaTest test = new JpaTest(managerr);
		EntityTransaction tx = managerr.getTransaction();
		tx.begin();
		try {

			/**
			 * lancer des fonctions pour enrichir la base de données
			 */
			test.createPerson();
			test.listPerson();
			test.createHome();
			test.ListHomes();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	public void createPerson() {
		int NbrEnrgPerson = manager.createQuery("SELECT a From Person a", Person.class).getResultList().size();

		/**
		 * Creer des personnes si le nombre d'enregistrement dans la table est inferieur
		 * ou eagle a 10
		 */
		if (NbrEnrgPerson <= 10) {
			Person vama = new Person("Diakite", "Hamed", "15");
			Person gatien = new Person("Anoh", "abbah", "23");

			/* Rendre les deux personnes amis */
			vama.addfriend(gatien);
			/* persister dans la base */
			manager.persist(vama);
			manager.persist(gatien);
		}
	}

	/**
	 * utilisation de Criteria pour effectuer la requete de selection des personnes
	 * dans la table
	 */
	public void listPerson() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Person> query = builder.createQuery(Person.class);
		Root<Person> personRoot = query.from(Person.class);
		query.select(personRoot);
		TypedQuery<Person> quer = manager.createQuery(query);
		List<Person> Persons = quer.getResultList();
		System.out.println(Persons.size());
		for (Person person : Persons) {
			System.out.println(person.toString());
		}
	}

	public void createHome() {
		int NbrEnrgPerson = manager.createQuery("SELECT a From Home a", Home.class).getResultList().size();
		if (NbrEnrgPerson <= 10) {
			Home studio = new Home();
			studio.setNbrpiece(10);
			studio.setTaille(100);
			manager.persist(studio);
			Home studio2 = new Home();
			studio2.setNbrpiece(20);
			studio2.setTaille(105);
			manager.persist(studio2);
		}
	}

	public void ListHomes() {
		List<Home> listhomes = manager.createNamedQuery("findAllHome").getResultList();
		for (Home h : listhomes) {
			System.out.println(h.toString());
		}
	}
}