package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author diakite, nevissa
 *
 */

@Entity
@DiscriminatorValue(value = "electronique")
public class ElectroDevice extends SmartDevices {

	private String type;

	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 * 
	 * the type to set
	 * 
	 */
	public void setType(String type) {
		this.type = type;
	}

}
