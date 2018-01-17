/**
 * 
 */
package dao;

import java.util.List;

import domain.*;

/**
 * @author Diakite
 *
 */
public interface DAO {
	
	public void CreateObjetInBase(Object object);
	
	public List<Person> getAllPersons();
	public Person getPerson(String id);
	public List<Home> getAllHomes();
	public List<Heater> getAllHeaters();
	public List<ElectroDevice> getAllElectroDevices();
	


}
