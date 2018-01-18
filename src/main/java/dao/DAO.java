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
		
	public List<Person> getAllPersons();
	public Person getPerson(int id);
	public List<Home> getAllHomes();
	public List<Heater> getAllHeaters();
	public List<ElectroDevice> getAllElectroDevices();
	

	public void CreatePerson(Person person);
	public void CreateHome(Home home);
	public void CreateHeater(Heater heater);
	public void CreateElectro(ElectroDevice electroDevice);
}
