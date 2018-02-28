package istic.fr.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import domain.Person;
import istic.fr.dao.daoGeneric.PersonDao;
import istic.fr.dao.daoImpl.PersonDaoImpl;

/**
 * 
 * @author Diakite, nevissa
 *
 */
@Path("/helloPerson")
public class SerPerson {
	private PersonDao daoP = new PersonDaoImpl();

	/**
	 * 
	 * @param JsonPerson
	 *            person json format
	 * @return person list
	 * @throws JSONException
	 *             exception d'erreur de format
	 */
	@POST
	@Path("/createPerson")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Person> ajouter(JSONObject JsonPerson) throws JSONException {
		Person person = new Person();
		person.setName(JsonPerson.getString("name"));
		person.setFirstname(JsonPerson.getString("prenom"));
		person.setEmail(JsonPerson.getString("mail"));
		person.setAge(JsonPerson.getString("age"));
		daoP.Ajouter(person);
		return daoP.getAll();

	}

	/**
	 * @return person list
	 */

	@GET
	@Path("/Persons")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll() {
		return daoP.getAll();

	}

	/**
	 * 
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

}
