package edu.sabanciuniv.it526.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import edu.sabanciuniv.it526.entity.Continent;
import edu.sabanciuniv.it526.entity.Country;
import edu.sabanciuniv.it526.service.ContinentService;
import edu.sabanciuniv.it526.service.CountryService;


@Named
@RequestScoped
public class AddCountryBean {
	

	@Inject
	private CountryService countryService;
	
	@Inject
	private ContinentService continentService;
	
	private Country country = new Country();
	private List<Continent> continents;
	private List<Country> countries;
	private int continentId;
	
	private Continent countryContinent;
	
	@PostConstruct
	public void initPage() {
		this.continents = continentService.getAllContinents();
		
	}

	public String savecountry() {
		this.countryContinent = continentService.getContinentById(this.continentId);
		this.country.setContinent(countryContinent);
		countryService.saveContryToDatabase(this.country);
		return "listcountries?faces-redirect=true";
	}

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	public ContinentService getContinentService() {
		return continentService;
	}

	public void setContinentService(ContinentService continentService) {
		this.continentService = continentService;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Continent> getContinents() {
		return continents;
	}

	public void setContinents(List<Continent> continents) {
		this.continents = continents;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public int getContinentId() {
		return continentId;
	}

	public void setContinentId(int continentId) {
		this.continentId = continentId;
	}

	public Continent getCountryContinent() {
		return countryContinent;
	}

	public void setCountryContinent(Continent countryContinent) {
		this.countryContinent = countryContinent;
	}

}
