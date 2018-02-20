/**
 * 
 */
package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
/**
 * @author Diakite
 *
 */
@Entity
public class Home {

	public int id;
	public String taille;
	public String nbrpiece;
	public List<Heater> heaters = new ArrayList<Heater>();
	/**
	 * 
	 */
	public Home() {
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
	 * @return the taille
	 */
	public String getTaille() {
		return taille;
	}
	/**
	 * @param taille the taille to set
	 */
	public void setTaille(String taille) {
		this.taille = taille;
	}
	/**
	 * @return the nbrpiece
	 */
	public String getNbrpiece() {
		return nbrpiece;
	}
	/**
	 * @param nbrpiece the nbrpiece to set
	 */
	public void setNbrpiece(String nbrpiece) {
		this.nbrpiece = nbrpiece;
	}
	/**
	 * @return the heaters
	 */
	@OneToMany
	@JoinColumn(name="Id_Home")
	public List<Heater> getHeaters() {
		return heaters;
	}
	/**
	 * @param heaters the heaters to set
	 */
	public void setHeaters(List<Heater> heaters) {
		this.heaters = heaters;
	}
	
	public void addHeater(Heater heater) {
		this.heaters.add(heater);
	}
		
}
