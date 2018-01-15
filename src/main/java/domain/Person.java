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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Diakite
 *
 */
@Entity
public class Person {

	public int id;
	public String name;
	public String firstname;
	public String age;
	public String email;
	public List<Person> friends = new ArrayList<Person>();
	public List<Home> homes = new ArrayList<Home>();
	public List<ElectroDevice> electrodevices = new ArrayList<ElectroDevice>();

	/**
	 * 
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, String firstname, String email) {
		this.name = name;
		this.firstname = firstname;
		this.email = email;
	}
	
	public Person(String name, String firstname, String age, String email) {
		this.name = name;
		this.firstname = firstname;
		this.age = age;
		this.email = email;
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the friends
	 */
	@ManyToMany
	public List<Person> getFriends() {
		return friends;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

	/**
	 * @return the homes
	 */
	@OneToMany
	@JoinColumn(name="Id_Person")
	public List<Home> getHomes() {
		return homes;
	}

	/**
	 * @param homes the homes to set
	 */
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	/**
	 * @return the electrodevices
	 */
	@OneToMany
	@JoinColumn(name="Id_Person")
	public List<ElectroDevice> getElectrodevices() {
		return electrodevices;
	}

	/**
	 * @param electrodevices the electrodevices to set
	 */
	public void setElectrodevices(List<ElectroDevice> electrodevices) {
		this.electrodevices = electrodevices;
	}
	
	public void addfriend(Person person) {
		this.friends.add(person);
	}
	
	@Override
	public String toString() {
		return "Person [id =" + id + ", name=" + name + ", firstname =" + firstname + ", Email = " + email + "]";
	}

}
