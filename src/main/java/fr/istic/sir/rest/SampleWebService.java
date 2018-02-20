package fr.istic.sir.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import dao.DAOImpl;
import domain.ElectroDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

@Path("/service")
public class SampleWebService {
	DAOImpl Dao = new DAOImpl();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}

	@GET
	@Path("/persons")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPerson() {
		return Dao.getAllPersons();
	}

	@GET
	@Path("/persons/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getperson(@PathParam("id") int id) {
		return Dao.getPerson(id);
	}

	@GET
	@Path("/homes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Home> getAllHome() {
		return Dao.getAllHomes();
	}

	@GET
	@Path("/heaters")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Heater> getAllHeater() {
		return Dao.getAllHeaters();
	}

	@GET
	@Path("/electro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ElectroDevice> getAllElectroDevice() {
		return Dao.getAllElectroDevices();
	}

	@POST
	@Path("/persons")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Person> createperson(JSONObject JsonPerson) throws JSONException {
		Person person = new Person();
		person.setName(JsonPerson.getString("name"));
		person.setFirstname(JsonPerson.getString("prenom"));
		person.setEmail(JsonPerson.getString("mail"));
		person.setAge(JsonPerson.getString("age"));
		Dao.CreatePerson(person);
		return Dao.getAllPersons();
		
	}

	@POST
	@Path("/homes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Home> createhome(JSONObject JsonHome) throws JSONException {
		Home home = new Home();
		home.setNbrpiece(JsonHome.getString("piece"));
		home.setTaille(JsonHome.getString("taile"));
		Dao.CreateHome(home);
		Person person = Dao.findPersonById(JsonHome.getInt("idp"));
		person.addHome(home);
		Dao.CreatePerson(person);
		return Dao.getAllHomes();
	}

	@POST
	@Path("/heaters")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Heater> createheater(JSONObject JsonHeater) throws JSONException {
		Heater heater = new Heater();
		heater.setName(JsonHeater.getString("heater"));
		heater.setPuissance(JsonHeater.getInt("puissance"));
		heater.setVolume(JsonHeater.getInt("volume"));
		Dao.CreateHeater(heater);
		Home home = Dao.findHomeById(JsonHeater.getInt("idh"));
		home.addHeater(heater);
		Dao.CreateHome(home);
		return Dao.getAllHeaters();

	}

	@POST
	@Path("/electros")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ElectroDevice> createElectro(JSONObject JsonElecto) throws JSONException {
		ElectroDevice electroDevice = new ElectroDevice();
		electroDevice.setName(JsonElecto.getString("electro"));
		electroDevice.setPuissance(JsonElecto.getInt("puissance"));
		electroDevice.setType(JsonElecto.getString("type"));
		Dao.CreateElectro(electroDevice);
		Person person = Dao.findPersonById(JsonElecto.getInt("idp"));
		person.addElectro(electroDevice);
		Dao.CreatePerson(person);
		return Dao.getAllElectroDevices();

	}
	
	@DELETE
	@Path("/persons")
	@Consumes(MediaType.APPLICATION_JSON)
	public void DeletePerson(JSONObject jsonPerson) throws JSONException {
		Dao.deletePerson(jsonPerson.getInt("id"));
		Dao.getAllPersons();
	}
}
