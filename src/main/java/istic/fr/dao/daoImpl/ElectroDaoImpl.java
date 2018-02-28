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
import istic.fr.dao.daoGeneric.DeviceDao;
import domain.ElectroDevice;

/**
 * 
 * @author Diakite, nevissa
 *
 */
public class ElectroDaoImpl implements DeviceDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	/**
	 * Persit electrodevice in the database
	 * 
	 * @param electro
	 *            electrodevice to persist
	 */

	public void Ajouter(ElectroDevice electro) {

		transaction.begin();
		try {
			manager.persist(electro);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Get electrodevice list using criteria api
	 * 
	 * @return electronics ElectroDevice list
	 */

	public List<ElectroDevice> getAll() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ElectroDevice> query = builder.createQuery(ElectroDevice.class);
		Root<ElectroDevice> ElectroRoot = query.from(ElectroDevice.class);
		query.select(ElectroRoot);
		TypedQuery<ElectroDevice> quer = manager.createQuery(query);
		List<ElectroDevice> electronics = quer.getResultList();
		return electronics;
	}

	/**
	 * Find electrodevice by Id
	 * 
	 * @return ElectroDevice
	 * @param id
	 *            id of electrodevice to find
	 * 
	 */

	public ElectroDevice findOne(int id) {
		return manager.find(ElectroDevice.class, id);
	}

	/**
	 * @param id
	 *            id of electrodevice to update
	 */
	public void updateElectro(int id) {
	
	}

	/**
	 * @param id
	 *            id of electrodevice to delete
	 */
	public void deleteElectro(int id) {
		// TODO Auto-generated method stub

	}

}
