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
import domain.SmartDevices;
import istic.fr.dao.daoGeneric.SmartDao;
import istic.fr.dao.daoImpl.SmartDaoImpl;

/**
 * 
 * @author Diakite, nevissa
 *
 */
@Path("/hello_Smart")
public class SerSmart {

	private SmartDao daoS = new SmartDaoImpl();

	/**
	 * 
	 * @param JsonSmart
	 *            Smartdevice json format
	 * @return smartdevice list
	 * @throws JSONException
	 *             exception d'erreur de format json
	 */

	@POST
	@Path("/createSmart")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<SmartDevices> ajouter(JSONObject JsonSmart) throws JSONException {
		SmartDevices smart = new SmartDevices();
		smart.setName(JsonSmart.getString("name"));
		smart.setPuissance(JsonSmart.getInt("puissance"));
		daoS.Ajouter(smart);
		return daoS.getAll();

	}

	/**
	 * 
	 * @return smartdevice list
	 */
	@GET
	@Path("/Smarts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SmartDevices> getAll() {
		return daoS.getAll();

	}

	/**
	 * 
	 * @param id
	 *            id of smartdevice to find
	 * @return smartdevice
	 */
	@GET
	@Path("/Smarts/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SmartDevices findOne(@PathParam(value = "id") int id) {
		return daoS.findOne(id);
	}

}
