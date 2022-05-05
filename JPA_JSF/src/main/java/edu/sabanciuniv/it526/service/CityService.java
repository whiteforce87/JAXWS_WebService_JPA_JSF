package edu.sabanciuniv.it526.service;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.sabanciuniv.it526.entity.CapitalCity;
import edu.sabanciuniv.it526.entity.City;

@Stateless
public class CityService {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void saveCapitalCityToDatabase(CapitalCity newCapitalCity) {
		entityManager.persist(newCapitalCity);
	}
	
	public void saveCityToDatabase(City newCity) {
		entityManager.persist(newCity);
	}
	
}
