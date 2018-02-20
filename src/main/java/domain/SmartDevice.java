/**
 * 
 */
package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Diakite
 *
 */
@Entity
@DiscriminatorColumn(name = "Type_Device")
@DiscriminatorValue(value = "SmartDevice")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SmartDevice {

	private int id;
	private String name;
	private int puissance;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the puissance
	 */
	public int getPuissance() {
		return puissance;
	}

	/**
	 * @param puissance
	 *            the puissance to set
	 */
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

}
