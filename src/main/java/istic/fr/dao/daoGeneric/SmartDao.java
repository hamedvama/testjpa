package istic.fr.dao.daoGeneric;

import java.util.List;

import domain.SmartDevices;

public interface SmartDao {
	/**
	 * @param smart
	 *            smartDevices to persist
	 */
	public void Ajouter(SmartDevices smart);

	/**
	 * @return All smartDevices
	 */
	public List<SmartDevices> getAll();

	/**
	 * @return SmartDevices
	 * @param id
	 *            id of smartdevices to find
	 * 
	 */
	public SmartDevices findOne(int id);

	/**
	 * 
	 * @param id
	 *            id of smartDevice to update
	 */
	public void updateSmart(int id);

	/**
	 * 
	 * @param id
	 *            id of smartDevice to delete
	 */
	public void deleteSmart(int id);

}
