


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

import domain.Heater;
import istic.fr.dao.daoGeneric.HeaterDao;
import istic.fr.dao.daoImpl.HeaterDaoImpl;

@Path("/hello_Heaters")
public class SerHeater {
	private HeaterDao daoH = new HeaterDaoImpl();

	
	// create a new heater

	@POST
	@Path("/CreateHeater")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Heater> ajouter(JSONObject JsonHeater) throws JSONException {
		Heater heater = new Heater();
		heater.setName(JsonHeater.getString("name"));
		daoH.Ajouter(heater);
		return daoH.getAll();	
	}
	
	
	// get list of heater

	@GET
	@Path("/Heaters")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Heater> getAll() {
		return daoH.getAll();
	
	}

	// get Heater by id

	@GET
	@Path("/Heaters/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Heater findOne(@PathParam(value="id")int id) {
		return daoH.findOne(id);
		}

	// get Heater by person

	public List<Heater> getByPersonne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	


}
