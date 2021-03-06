package istic.fr.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import domain.Home;
import istic.fr.dao.daoGeneric.HomeDao;
import istic.fr.dao.daoImpl.HomeDaoImp;

/**
 * 
 * @author Diakite, nevissa
 *
 */
@Path("/hello_Homes")
public class SerHome {
	private HomeDao daoH = new HomeDaoImp();

	/**
	 * create home
	 * 
	 * @param taille
	 *            home taille
	 * @param nbrPieces
	 *            home nbrpieces
	 * @return Home
	 */
	@POST
	@Path("/createHome")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Home ajouter(Home home) {
		this.daoH.Ajouter(home);
		return home;
	}

	/**
	 * @return list of homes
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Home> getAll() {
		return daoH.getAll();
	}

	/**
	 * get home by id
	 * 
	 * @param id
	 *            id of home to find
	 * 
	 * @return home
	 */

	@GET
	@Path("/Homes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Home findOne(@PathParam(value = "id") int id) {
		return daoH.findOne(id);
	}
	
	/**
	 * delete Home by id
	 * @param id
	 * 			id home to delete
	 */
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteHome(@PathParam(value = "id") int id) {
		System.out.println("supprimer");
		daoH.deleteHome(id);
	}
	

}
