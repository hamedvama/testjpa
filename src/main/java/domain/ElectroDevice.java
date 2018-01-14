/**
 * 
 */
package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * @author Diakite
 *
 */
@Entity
@Table 
public class ElectroDevice {
	
	public int id;
	public String electro_name;

	/**
	 * 
	 */
	public ElectroDevice() {
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
	 * @return the electro_name
	 */
	public String getElectro_name() {
		return electro_name;
	}

	/**
	 * @param electro_name the electro_name to set
	 */
	public void setElectro_name(String electro_name) {
		this.electro_name = electro_name;
	}
	
	
}
