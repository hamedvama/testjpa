package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author diakite, nevissa
 *
 */

@Entity
@Table(name = "home")

/** named query */

@NamedQuery(name = "findAllHome", query = "select h from Home h")
public class Home {

	public int id;
	public int taille;
	public int nbrpiece;
	public List<Heater> heaters = new ArrayList<Heater>();

	/**
	 * constructor
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
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * @param taille
	 *            the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	/**
	 * @return int the nbrpiece
	 */
	public int getNbrpiece() {
		return nbrpiece;
	}

	/**
	 * @param nbrpiece
	 *            the nbrpiece to set
	 */
	public void setNbrpiece(int nbrpiece) {
		this.nbrpiece = nbrpiece;
	}

	/**
	 * @return heaters
	 */
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_Home")
	public List<Heater> getHeaters() {
		return heaters;
	}

	/**
	 * @param heaters
	 *            the heaters to set
	 */
	public void setHeaters(List<Heater> heaters) {
		this.heaters = heaters;
	}

	/**
	 * add a heater to the heater list
	 * 
	 * @param heater
	 * 				heater add to the list
	 */
	public void addHeater(Heater heater) {
		this.heaters.add(heater);
	}

	@Override
	public String toString() {
		return "Home [id =" + id + ", Taille=" + taille + ", Nombre de pièces =" + nbrpiece + "]";
	}
}
