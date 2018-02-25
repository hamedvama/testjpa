package istic.fr.dao.daoGeneric;

import java.util.List;

import domain.Home;

public interface HomeDao {
	/**
	 * persist
	 *   home
	 */
public void Ajouter(Home heater) ;

/**
 * @return
 *   All homes
 */
public List<Home>getAll();

/**
 * find
 *  home by id
 */

public Home findOne(int id);



}
