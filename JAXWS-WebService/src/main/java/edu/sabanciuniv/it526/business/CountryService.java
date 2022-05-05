package edu.sabanciuniv.it526.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.sabanciuniv.it526.entity.Country;


@Stateless //Bu annotation basit bir java sınıfını EJB (Managed object) ye dönüştürür
public class CountryService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Country> getCountriesById(int countryId) {
		List <Country> countries = entityManager.createQuery("select i from Country i Where continent_id = :id",Country.class).
				setParameter("id", countryId).getResultList();

		return countries;
	}
	

}
