package istic.fr.dao.daoGeneric;

import java.util.List;

import domain.*;

public interface DeviceDao {
	
	/**
	 * persist
	 * electroDevice
	 */
   public void Ajouter(ElectroDevice electro) ;
   
	/**
	 * @return
	 *            All electroDevice
	 */
   public List<ElectroDevice>getAll();
   
	/**
	 * find electroDevice by id
	 *       
	 */
   public ElectroDevice findOne(int id);
 
   

}
