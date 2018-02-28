package istic.fr.dao.daoGeneric;

import java.util.List;

import domain.*;

public interface DeviceDao {

	/**
	 * @param electro
	 * 						electrodevice to persist
	 */
	public void Ajouter(ElectroDevice electro);

	/**
	 * @return All electroDevice
	 */
	public List<ElectroDevice> getAll();

	/**
	 * @return ElectroDevice
	 * @param id
	 * 			id of electrodevice to find
	 */
	public ElectroDevice findOne(int id);
	
	/**
	 * 
	 * @param id
	 * id of electrodevice to update
	 */
	public void updateElectro(int id);

	/**
	 * 
	 * @param id
	 * id of electrodevice to delete
	 */
	public void deleleElectro(int id);
}
