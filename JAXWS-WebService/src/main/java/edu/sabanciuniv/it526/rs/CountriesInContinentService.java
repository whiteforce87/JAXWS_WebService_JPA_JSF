package edu.sabanciuniv.it526.rs;


import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sabanciuniv.it526.business.CountryService;
import edu.sabanciuniv.it526.entity.Country;

@Stateless
@Path("CountryService")
public class CountriesInContinentService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject 
	CountryService countryService;

	
	
	@GET
	@Path("getAllCountries")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Country> getAllCountries()
	{
		List <Country> countries = entityManager.createQuery("select i from Country i",Country.class).getResultList();
		
		return countries;
	}
	
	
	@GET
	@Path("getCountriesById/{continentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountriesById(@PathParam("continentId") int continentId)
	{
		List <Country> countries = countryService.getCountriesById(continentId);
		

		return countries;
	}
	

}
