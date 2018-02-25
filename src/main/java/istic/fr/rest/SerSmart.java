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
 

@Path("/hello_Smart")
public class SerSmart {
	
	
private  SmartDao daoS= new SmartDaoImpl();
     
	
	// create a new smartDevice
	
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
	
	// get list of smartDevices
	
	@GET
	@Path("/Smarts")
    @Produces(MediaType.APPLICATION_JSON)
	public List<SmartDevices> getAll() {
		return daoS.getAll();
		
		
	}
	
	// get smartDevice by id


	
	@GET
	@Path("/Smarts/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SmartDevices findOne(@PathParam(value="id")int id) {
		return daoS.findOne(id);
		}

	
	

	


}
