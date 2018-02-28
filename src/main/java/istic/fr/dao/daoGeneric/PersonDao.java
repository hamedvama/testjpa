package istic.fr.dao.daoGeneric;

import java.util.List;

import domain.Person;

public interface PersonDao {

	/**
	 * @param person
	 * 				person to persist
	 * 
	 */
	public void Ajouter(Person person);

	/**
	 * @return All person
	 */
	public List<Person> getAll();

	/**
	 * @return Person
	 * @param id
	 * 			id of person to find
	 */
	public Person findOne(int id);

}
