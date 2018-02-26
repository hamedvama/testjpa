
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

@Path("/helloPerson")

public class SerPer  {
	private  PersonDao daoP= new  PersonDaoImpl();
     
	
	// create a new person
	
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
	
	// get list of persons
	
	@GET
	@Path("/Persons")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll() {
		return daoP.getAll();
		
		
	}
	
	// get person by id


	
	@GET
	@Path("/Persons/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person findOne(@PathParam(value="id")int id) {
		return daoP.findOne(id);
		}

	
	

	

}

