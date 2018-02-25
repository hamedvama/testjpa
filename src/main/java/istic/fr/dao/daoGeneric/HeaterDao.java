package istic.fr.dao.daoGeneric;


import java.util.List;
import domain.Heater;

public interface HeaterDao {
	
	/**
	 * persist
	 * heater
	 */
      public void Ajouter(Heater heater) ;
      
  	/**
  	 * @return
  	 *           ALL HEATER
  	 */
      public List<Heater>getAll();
      
  	/**
  	 * Find heater by id
  	 *            
  	 */
	  public Heater findOne(int id);


}
