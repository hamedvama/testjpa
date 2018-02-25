/**
 * 
 */
package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * @author nevissa
 *
 */

 @Entity
 @DiscriminatorValue(value="electronique")
public class ElectroDevice extends SmartDevices{
	
	private String type;
	
	/**
	 * @return
	 *            the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
