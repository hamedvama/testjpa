package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * 
 * @author Diakite,nevissa
 *
 */
@Entity
public class Person {

	public int id;
	public String name;
	public String firstname;
	public String email;
	private String age;
	public List<Person> friends = new ArrayList<Person>();
	public List<Home> homes = new ArrayList<Home>();
	public List<ElectroDevice> electrodevices = new ArrayList<ElectroDevice>();

	/**
	 * constructor
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String firstname, String age) {
		this.name = name;
		this.firstname = firstname;
		this.age = age;
	}

	public Person(String name, String firstname, String email, String age) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.age = age;
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
	 * 
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * 
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the friends
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	@JoinColumn(name="friend")
	public List<Person> getFriends() {
		return friends;
	}

	/**
	 * @param friends
	 *            the friends to set
	 */
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

	/**
	 * @return the homes
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	@JoinColumn(name = "Id_Person")
	public List<Home> getHomes() {
		return homes;
	}

	/**
	 * @param homes
	 *            the homes to set
	 */
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	public void addHome(Home home) {
		this.homes.add(home);
	}

	/**
	 * @return the electrodevices
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_Person")
	public List<ElectroDevice> getElectrodevices() {
		return electrodevices;
	}

	/**
	 * @param electrodevices
	 *            the electrodevices to set
	 */
	public void setElectrodevices(List<ElectroDevice> electrodevices) {
		this.electrodevices = electrodevices;
	}

	/**
	 * add one electrodevice to the electrodevice list
	 * 
	 * @param electroDevice
	 * 						add to the electrodevices list
	 */
	public void addElectro(ElectroDevice electroDevice) {
		this.electrodevices.add(electroDevice);
	}

	/**
	 * add one friend to the friends list
	 * 
	 * @param person
	 * 				add to the friends list
	 */
	public void addfriend(Person person) {
		this.friends.add(person);
	}

	@Override
	public String toString() {
		return "Person [id =" + id + ", name=" + name + ", firstname =" + firstname + ", Email = " + email + "]";
	}

}
