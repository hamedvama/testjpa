package istic.fr.dao.daoGeneric;

import java.util.List;

import domain.SmartDevices;

public interface SmartDao {
	/**
	 * persist
	 *  smartDevices
	 */
	public void Ajouter(SmartDevices smart) ;	
	
	/**
	 * @return
	 *  All smartDevices
	 */
	public List<SmartDevices>getAll();
	
	
	/**
	 * find smartDevices by id
	 *            
	 */
	public SmartDevices findOne(int id);
	
}
