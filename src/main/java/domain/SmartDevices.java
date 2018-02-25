package domain;

import javax.persistence.*;

/*  cas heritage avec table par classe
 * @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
 * @DiscriminatorValue(value="smart")
   @Inheritance(strategy=InheritanceType.JOINED)
 * */
 //heritage avec single table
@DiscriminatorColumn(name="TYPE_DEVICE")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="smart")
@Entity
public class SmartDevices {
	
	
	public void setId(int id) {
		this.id = id;
	}


	private int id;
	private String name;
	private int puissance;
	
	/**
	 * return 
	 * the name
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
	 * @return
	 *            the puissance
	 */
	public int getPuissance() {
		return puissance;
	}
	
	/**
	 * @param puissance 
	 *         to set 
	 */
	
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	
	
	/**
	 * @return
	 *            id
	 */
	@Id
	@GeneratedValue()
	public int getId() {
		return id;
	}


}
