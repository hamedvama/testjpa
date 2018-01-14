package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * @author Diakite
 *
 */
@Entity
public class Heater {
	
	public int id;
	public String heater_name;
	
	/**
	 * 
	 */
	public Heater() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the heater_name
	 */
	public String getHeater_name() {
		return heater_name;
	}

	/**
	 * @param heater_name the heater_name to set
	 */
	public void setHeater_name(String heater_name) {
		this.heater_name = heater_name;
	}
	
	
}
