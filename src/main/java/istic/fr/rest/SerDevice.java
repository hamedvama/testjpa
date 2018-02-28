package istic.fr.rest;

import java.util.List;

import javax.ws.rs.Consumes;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import domain.ElectroDevice;
import istic.fr.dao.daoGeneric.DeviceDao;
import istic.fr.dao.daoImpl.ElectroDaoImpl;

/**
 * 
 * @author Diakite, nevissa
 *
 */

@Path("/hello_Devices")
public class SerDevice {
	DeviceDao dao = new ElectroDaoImpl();

	/**
	 * service permit to persist on device
	 * 
	 * @param type : type of device
	 * @param puissance : puissance of device
	 * @param name : name of device
	 * @return ElectroDevice
	 */
	@POST
	@Path("/createElectro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")

	public ElectroDevice ajouter(@FormParam("type") String type, @FormParam("puissance") int puissance,
			@FormParam("name") String name) {
		ElectroDevice electro = new ElectroDevice();
		electro.setType(type);
		electro.setPuissance(puissance);
		electro.setName(name);
		dao.Ajouter(electro);
		return electro;
	}

	
	/**
	 * @return list 
	 * 				of electroDevices
	 */
	@GET
	@Path("/Electros")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ElectroDevice> getAll() {
		return dao.getAll();
	}

	
	/**
	 * 
	 * @param id
	 * 			id of electrodevice to find
	 * @return ElectroDevice
	 */
	@GET
	@Path("/Electros/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ElectroDevice findOne(@PathParam(value = "id") int id) {
		return dao.findOne(id);
	}

}
