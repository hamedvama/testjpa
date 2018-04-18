
package istic.fr.rest;

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
import istic.fr.dao.daoGeneric.HeaterDao;
import istic.fr.dao.daoImpl.HeaterDaoImpl;
import domain.Heater;

/**
 * 
 * @author Diakite, nevissa
 *
 */

@Path("/hello_Heaters")
public class SerHeater {
	private HeaterDao daoheat = new HeaterDaoImpl();

	/**
	 * service permit to persist one heater
	 * 
	 * @return homes persisted
	 * @throws JSONException
	 * 						exception d'erreur de format
	 */
	@POST
	@Path("/CreateHeater")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Heater ajouter(Heater heater) {
		this.daoheat.Ajouter(heater);
		return heater;
	}

	/**
	 * 
	 * @return homes list
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Heater> getAll() {
		return this.daoheat.getAll();

	}

	/**
	 * get Heater by id
	 * 
	 * @param id
	 *            id of home to find
	 * @return heater
	 */
	@GET
	@Path("/Heaters/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Heater findOne(@PathParam(value = "id") int id) {
		return this.daoheat.findOne(id);
	}

	/**
	 * get Heater by person
	 * 
	 * @param id
	 *            id of person
	 * @return heater list
	 */

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteHome(@PathParam(value = "id") int id) {
		System.out.println("supprimer");
		this.daoheat.deleteHeater(id);
	}
	

}
