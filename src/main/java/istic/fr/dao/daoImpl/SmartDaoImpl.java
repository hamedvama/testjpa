package istic.fr.dao.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import istic.fr.dao.daoGeneric.SmartDao;
import domain.SmartDevices;

public class SmartDaoImpl implements SmartDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	/**
	 * Persist smartdevice
	 * 
	 * @param smart
	 * 				smartdevice to persist
	 * 
	 */

	public void Ajouter(SmartDevices smart) {

		transaction.begin();
		try {
			manager.persist(smart);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Get smartdevice list using hql
	 * 
	 * @return Devices
	 */

	public List<SmartDevices> getAll() {
		List<SmartDevices> Devices = manager.createQuery("Select s From SmartDevices s", SmartDevices.class).getResultList();
		return Devices;
	}

	/***
	 * Find smartdevice by Id
	 * 
	 * @param id
	 * 			id of SmartDevice to find
	 * @return SmartDevices
	 */

	public SmartDevices findOne(int id) {
		return manager.find(SmartDevices.class, id);

	}
	
	/**
	 * @param id
	 *            id of smart to update
	 */
	public void updateSmart(int id) {

	}

	/**
	 * @param id
	 *            id of smart to delete
	 */
	public void deleteSmart(int id) {
		

	}

}
