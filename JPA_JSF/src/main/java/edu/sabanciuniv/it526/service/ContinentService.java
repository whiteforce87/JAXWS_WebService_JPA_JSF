package edu.sabanciuniv.it526.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.sabanciuniv.it526.entity.Continent;
import edu.sabanciuniv.it526.entity.Country;

@Stateless
public class ContinentService {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	

	public List<Continent> getAllContinents(){
		
		List <Continent> continents = entityManager.createQuery("select i from Continent i",Continent.class).getResultList();
		
		for (Continent co : continents) {
			
			for (Country ci : co.getCountries()) {
				System.out.println(ci.getId());
			}
		}
		
		return continents;
	}
	
	
	public void saveContinentToDatabase(Continent newContinent) {
		entityManager.persist(newContinent);
	}
	
	public Continent getContinentById(int continentId) {
		return entityManager.find(Continent.class, continentId);
	}

	
}
