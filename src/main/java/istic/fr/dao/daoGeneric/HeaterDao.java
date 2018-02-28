package istic.fr.dao.daoGeneric;

import java.util.List;
import domain.Heater;

public interface HeaterDao {

	/**
	 * @param heater
	 *            heater to persist
	 * 
	 */
	public void Ajouter(Heater heater);

	/**
	 * @return heater list
	 */
	public List<Heater> getAll();

	/**
	 * @return Heater
	 * @param id
	 *            id of heater to find
	 */
	public Heater findOne(int id);

	/**
	 * 
	 * @param id
	 *            id of heater to update
	 */
	public void updateHeater(int id);

	/**
	 * 
	 * @param id
	 *            id of heater to delete
	 */
	public void deleteHeater(int id);

}
