package istic.fr.dao.daoGeneric;

import java.util.List;

import domain.Home;

public interface HomeDao {
	/**
	 * @param heater
	 *            heater to persist
	 */
	public void Ajouter(Home heater);

	/**
	 * @return All homes
	 */
	public List<Home> getAll();

	/**
	 * @return Home
	 * @param id
	 *            id of home to find
	 */

	public Home findOne(int id);

	/**
	 * 
	 * @param id
	 *            id of Home to update
	 */
	public void updateHome(int id);

	/**
	 * 
	 * @param id
	 *            id of home to delete
	 */
	public void deleteHome(int id);

}
