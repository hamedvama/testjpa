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
import domain.Home;
import istic.fr.dao.daoGeneric.HomeDao;
import istic.fr.dao.daoImpl.HomeDaoImp;

@Path("/hello_Homes")

public class SerHome {
	private HomeDao daoH= new HomeDaoImp();
	//create home
	
	@POST
 	@Path("/createHome")
    @Produces(MediaType.APPLICATION_JSON)
 	@Consumes("application/x-www-form-urlencoded")
	
     public Home ajouter(@FormParam("taille")int taille,@FormParam("nbrPieces")int nbrPieces) {
     Home home= new Home();
     home.setTaille(taille);
     home.setNbrpiece(nbrPieces);  
     this.daoH.Ajouter(home);
     return home;
      }
	
	
	// return list of homes
	
	@GET
	@Path("/Homes")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Home> getAll() {
		return daoH.getAll();
		}
     
	// get home by id

	@GET
	@Path("/Homes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Home findOne(@PathParam(value="id")int id) {
		return daoH.findOne(id);
		}

}
