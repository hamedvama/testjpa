package dao;

import java.io.PrintWriter;
import java.security.Permissions;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.ElectroDevice;
import domain.Heater;
import domain.Home;
import domain.Person;
import domain.SmartDevice;

public class DAOImpl implements DAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction tx = manager.getTransaction();

	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub

		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		System.out.println("List of Person:" + resultList.size());

		return resultList;
	}

	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		Person person;
		person = manager.createQuery("Select a From Person a where id =" + id, Person.class).getSingleResult();
		return person;
	}

	public List<Home> getAllHomes() {
		// TODO Auto-generated method stub
		List<Home> resultList = manager.createQuery("Select a From Home a", Home.class).getResultList();
		System.out.println("List of Home:" + resultList.size());

		return resultList;
	}

	public List<Heater> getAllHeaters() {
		// TODO Auto-generated method stub
		List<Heater> resultList = manager.createQuery("Select a From Heater a", Heater.class).getResultList();
		System.out.println("List of Heater:" + resultList.size());

		return resultList;
	}

	public List<ElectroDevice> getAllElectroDevices() {
		// TODO Auto-generated method stub
		List<ElectroDevice> resultList = manager.createQuery("Select a From Electrodevice a", ElectroDevice.class)
				.getResultList();
		System.out.println("List of Electrodevice:" + resultList.size());

		return resultList;
	}

	public void CreatePerson(Person person) {
		// TODO Auto-generated method stub
		tx.begin();
		try {
			manager.persist(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	public Person findPersonById(int id) {
		Person person = manager.find(Person.class, id);
		return person;
	}

	public void CreateHome(Home home) {
		// TODO Auto-generated method stub
		tx.begin();

		try {
			manager.persist(home);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	public Home findHomeById(int id) {
		Home home = manager.find(Home.class, id);

		return home;
	}

	public void CreateHeater(Heater heater) {
		// TODO Auto-generated method stub
		tx.begin();

		try {
			manager.persist(heater);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	public void CreateElectro(ElectroDevice electroDevice) {
		// TODO Auto-generated method stub
		tx.begin();

		try {
			manager.persist(electroDevice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	public void deletePerson(int id) {
		manager.createQuery("Delete From Person where id =" + id, Person.class).getResultList();
	}
}
