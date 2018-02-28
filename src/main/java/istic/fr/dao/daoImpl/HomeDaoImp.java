package istic.fr.dao.daoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import istic.fr.dao.daoGeneric.HomeDao;
import domain.Home;

/**
 * 
 * @author Diakite, nevissa
 *
 */
public class HomeDaoImp implements HomeDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	/**
	 * Persit home in the database
	 * 
	 * @param home
	 * 				home to persist
	 */
	public void Ajouter(Home home) {

		transaction.begin();
		try {
			manager.persist(home);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Get homes list of data base using hsql
	 * @return listhomes
	 */
	public List<Home> getAll() {
		List<Home> listhomes = manager.createNamedQuery("findAllHome").getResultList();
		return listhomes;
	}

	/**
	 * Find a home by Id
	 * 
	 * @param id
	 * 			id of home to find
	 * @return home
	 */
	public Home findOne(int id) {
		return manager.find(Home.class, id);
	}

}
