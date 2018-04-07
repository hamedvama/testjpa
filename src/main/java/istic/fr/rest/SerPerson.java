package istic.fr.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Home;
import domain.Person;
import istic.fr.dao.daoGeneric.PersonDao;
import istic.fr.dao.daoImpl.PersonDaoImpl;

/**
 * 
 * @author Diakite, nevissa
 *
 */
@Path("/hello_Person")
public class SerPerson {
	private PersonDao daoP = new PersonDaoImpl();

	/**
	 * persist a person
	 * @param JsonPerson
	 *            person json format
	 * @return person persisted
	 */
	@POST
	@Path("/createPerson")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Person ajouter(Person person) {
		this.daoP.Ajouter(person);
		return person;
	}

	/**
	 * get all persons of the data base 
	 * @return person list
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll() {
		return daoP.getAll();
	}
	

	/**
	 * find a person in database
	 * @param id
	 *            id person to find
	 * @return person
	 */
	@GET
	@Path("/Persons/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person findOne(@PathParam(value = "id") int id) {
		return daoP.findOne(id);
	}
	
	/**
	 * update a person
	 * @param id 
	 * 			id of person to update
	 * @param JsonPerson
	 * 					person json form
	 * @return person 
	 * 				person return
	 * @throws JSONException
	 * 						exception of json formt
	 */
	@PUT
	@Path("/Persons/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person Update(@PathParam(value = "id") int id, JSONObject JsonPerson)  throws JSONException {
		
		Person person = daoP.findOne(id);
		
		person.setName(JsonPerson.getString("name"));
		person.setFirstname(JsonPerson.getString("prenom"));
		person.setEmail(JsonPerson.getString("mail"));
		person.setAge(JsonPerson.getString("age"));
		daoP.updatePerson(person);
		
		return daoP.findOne(id);
	}
	
	
	/**
	 * 
	 * @param id
	 */
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletPerson(@PathParam(value = "id") int id){
		daoP.deletePerson(id);
	}
	

}
