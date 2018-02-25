package istic.fr.dao.daoGeneric;

import java.util.List;

import domain.Person;

public interface PersonDao {
	
	/**
	 * persist
	 * person
	 */
public void Ajouter(Person person) ;

/**
 * @return
 * All person
 */
public List<Person>getAll();


/**
 * Find person by id
 *            
 */
public Person findOne(int id);

}
