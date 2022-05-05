package edu.sabanciuniv.it526.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.sabanciuniv.it526.entity.City;
import edu.sabanciuniv.it526.entity.Country;

@Stateless
public class CountryService {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	

	public List<Country> getAllCountries(){
		
		List <Country> countries = entityManager.createQuery("select i from Country i",Country.class).getResultList();
		
		for (Country co : countries) {
			
			for (City ci : co.getCities()) {
				System.out.println(ci.getId());
			}
		}
		
		return countries;
	}
	
	
	public void saveContryToDatabase(Country newCountry) {
		entityManager.persist(newCountry);
	}
	
	public void updateCountryOnDatabase(Country tobeUpdated) {
		entityManager.merge(tobeUpdated);
		
	}
	
	public void deleteCountryOnDatabase(int countryId) {
		Country tobeRemoved = entityManager.find(Country.class, countryId);
		for (City a: tobeRemoved.getCities()){
			entityManager.remove(a);
		}
		entityManager.remove(tobeRemoved);	
	}
	
	public Country getCountryById(int countryId) {
		return entityManager.find(Country.class, countryId);
	}
	
	public List<Country> getCountriesById(int countryId) {
		List <Country> countries = entityManager.createQuery("select i from Country i Where i.continent.id = :id",Country.class).
				setParameter("id", countryId).getResultList();

	
		return countries;
	}
	
}
