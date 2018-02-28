
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
	private HeaterDao home = new HeaterDaoImpl();

	/**
	 * service permit to persist one heater
	 * 
	 * @param JsonHeater
	 *            heater json formt
	 * @return homes list
	 * @throws JSONException
	 * 						exception d'erreur de format
	 */
	@POST
	@Path("/CreateHeater")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Heater> ajouter(JSONObject JsonHeater) throws JSONException {
		Heater heater = new Heater();
		heater.setName(JsonHeater.getString("name"));
		home.Ajouter(heater);
		return home.getAll();
	}

	/**
	 * 
	 * @return homes list
	 */
	@GET
	@Path("/Heaters")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Heater> getAll() {
		return home.getAll();

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
		return home.findOne(id);
	}

	/**
	 * get Heater by person
	 * 
	 * @param id
	 *            id of person
	 * @return heater list
	 */

	public List<Heater> getByPersonne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
