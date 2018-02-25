/**
 * 
 */
package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author nevissa
 *
 */

@Entity
@Table(name = "home")   

/** named query*/

@NamedQuery(name = "findAllHome", query ="select h from Home h")  
public class Home {
   
	public int id;
	public int taille;
	public int nbrpiece;
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

	/**
	 * @return the taille
	 */
	public int  getTaille() {
		return taille;
	}
	/**
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}
	/**
	 * @return the nbrpiece
	 */
	public int getNbrpiece() {
		return nbrpiece;
	}
	/**
	 * @param nbrpiece the nbrpiece to set
	 */
	public void setNbrpiece(int nbrpiece) {
		this.nbrpiece = nbrpiece;
	}
	/**
	 * @return the heaters
	 */
	@OneToMany(fetch=FetchType.LAZY)
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
	
	public void setId(int id) {
		this.id = id;
	}
	public void addHeater(Heater heater) {
		this.heaters.add(heater);
	}
		
}
