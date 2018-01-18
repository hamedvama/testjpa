package fr.istic.sir.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.DAOImpl;
import domain.ElectroDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

@Path("/service")
public class SampleWebService {
	DAOImpl userDao = new DAOImpl();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}

	@GET
	@Path("/persons")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPerson() {
		return userDao.getAllPersons();
	}

	// @GET
	// @Path("/person/{id}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public Home getperson(@PathParam("id") String id) {
	//
	// return userDao.getPerson(@PathParam("id"));
	// }

	@GET
	@Path("/homes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Home> getAllHome() {
		return userDao.getAllHomes();
	}

	@GET
	@Path("/heaters")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Heater> getAllHeater() {
		return userDao.getAllHeaters();
	}

	@GET
	@Path("/electro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ElectroDevice> getAllElectroDevice() {
		return userDao.getAllElectroDevices();
	}
	
	@POST
	@Path("/homes")
	@Produces(MediaType.APPLICATION_JSON)
	public void createperson() {
		
	}
	
	
}
