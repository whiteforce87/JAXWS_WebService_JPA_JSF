package edu.sabanciuniv.it526.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

import edu.sabanciuniv.it526.entity.CapitalCity;
import edu.sabanciuniv.it526.entity.City;
import edu.sabanciuniv.it526.entity.Continent;
import edu.sabanciuniv.it526.entity.Country;
import edu.sabanciuniv.it526.service.CityService;
import edu.sabanciuniv.it526.service.ContinentService;
import edu.sabanciuniv.it526.service.CountryService;

@Named
@RequestScoped
public class CountryBean {
	
	private Country country= new Country();
	
	
	private List<Country> countries;
	
	@Inject
	private CountryService countryService;
	
	@Inject
	private ContinentService continentService;
	
	@Inject
	private CityService cityService;
	
	@PostConstruct
	public void initPage() {
		if(countryService.getAllCountries().isEmpty()) {
		existedCountries();
		}
		this.countries = countryService.getAllCountries();
		
	}

	public void saveCountry() {
		countryService.saveContryToDatabase(this.country);
		this.countries = countryService.getAllCountries();
		this.country = new Country();
	}
	
	public String deleteCountry(int countryId)
	{
		countryService.deleteCountryOnDatabase(countryId);
		return "listcountries.xhtml?faces-redirect=true";
	}
	
	public Country getCountry() {
		return country;
	}



	public void setCountry(Country country) {
		this.country = country;
	}



	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	public void updateCountry(RowEditEvent evt) {
		Country tobeUpdated = (Country)evt.getObject();
		countryService.updateCountryOnDatabase(tobeUpdated);
		
	}
	

	 
	public void existedCountries() {
		
		Continent asia = new Continent("Asia",31000000);
		continentService.saveContinentToDatabase(asia);
		Country china = new Country("China",asia);
		countryService.saveContryToDatabase(china);
		CapitalCity pekin = new CapitalCity("Pekin", 20000000, china);
		cityService.saveCapitalCityToDatabase(pekin);
		china.setCapitalCity(pekin);
		countryService.updateCountryOnDatabase(china);
		
		Country russia = new Country("Russia",asia);
		countryService.saveContryToDatabase(russia);
		CapitalCity moskova = new CapitalCity("Moskova", 15000000, russia);
		cityService.saveCapitalCityToDatabase(moskova);
		russia.setCapitalCity(moskova);
		countryService.updateCountryOnDatabase(russia);
	
		
		Continent europe = new Continent("Europe",22000000);
		continentService.saveContinentToDatabase(europe);
		Country turkey = new Country("Turkey",europe);
		countryService.saveContryToDatabase(turkey);
		City istanbul = new City("Istanbul", 13000000, turkey);
		cityService.saveCityToDatabase(istanbul);
		CapitalCity ankara = new CapitalCity("Ankara", 10000000, turkey);
		cityService.saveCapitalCityToDatabase(ankara);
		turkey.setCapitalCity(ankara);
		countryService.updateCountryOnDatabase(turkey);
		
		
		Country germany = new Country("Germany",europe);
		countryService.saveContryToDatabase(germany);
		CapitalCity berlin = new CapitalCity("Berlin", 8000000, germany);
		cityService.saveCapitalCityToDatabase(berlin);
		germany.setCapitalCity(berlin);
		countryService.updateCountryOnDatabase(germany);
		Country italy = new Country("Italy",europe);
		countryService.saveContryToDatabase(italy);
		CapitalCity roma = new CapitalCity("Roma", 5000000, italy);
		cityService.saveCapitalCityToDatabase(roma);
		italy.setCapitalCity(roma);
		countryService.updateCountryOnDatabase(italy);
		
		
		Continent africa = new Continent("Africa",30000000);
		continentService.saveContinentToDatabase(africa);
		Country kenya = new Country("Kenya",africa);
		countryService.saveContryToDatabase(kenya);
		CapitalCity nairobi = new CapitalCity("Nairobi", 6000000, kenya);
		cityService.saveCapitalCityToDatabase(nairobi);
		kenya.setCapitalCity(nairobi);
		countryService.updateCountryOnDatabase(kenya);
		
		Country southAfrica = new Country("South Africa",africa);
		countryService.saveContryToDatabase(southAfrica);
		CapitalCity capeTown = new CapitalCity("Cape Town", 2000000, southAfrica);
		cityService.saveCapitalCityToDatabase(capeTown);
		southAfrica.setCapitalCity(capeTown);
		countryService.updateCountryOnDatabase(southAfrica);
		
		Continent northAmerica = new Continent("North America",21000000);
		continentService.saveContinentToDatabase(northAmerica);
		Country canada = new Country("Kanada",northAmerica);
		countryService.saveContryToDatabase(canada);
		CapitalCity ottowa = new CapitalCity("Ottowa", 3000000, canada);
		cityService.saveCapitalCityToDatabase(ottowa);
		canada.setCapitalCity(ottowa);
		countryService.updateCountryOnDatabase(canada);
		Country unitedStates = new Country("United States of America",northAmerica);
		countryService.saveContryToDatabase(unitedStates);
		CapitalCity washingtonDC = new CapitalCity("Washington D.C.", 10000000, unitedStates);
		cityService.saveCapitalCityToDatabase(washingtonDC);
		unitedStates.setCapitalCity(washingtonDC);
		countryService.updateCountryOnDatabase(unitedStates);
		
		Continent southAmerica = new Continent("South America",18000000);
		continentService.saveContinentToDatabase(southAmerica);
		Country colombia = new Country("Colombia",southAmerica);
		countryService.saveContryToDatabase(colombia);
		CapitalCity bogoto = new CapitalCity("Bogoto", 10000000, colombia);
		cityService.saveCapitalCityToDatabase(bogoto);
		colombia.setCapitalCity(bogoto);
		countryService.updateCountryOnDatabase(colombia);
		Country cuba = new Country("Cuba",southAmerica);
		countryService.saveContryToDatabase(cuba);
		CapitalCity havana = new CapitalCity("Havana", 9000000, cuba);
		cityService.saveCapitalCityToDatabase(havana);
		cuba.setCapitalCity(havana);
		countryService.updateCountryOnDatabase(cuba);
		
		Continent antarctica = new Continent("Antarctica",14000000);
		continentService.saveContinentToDatabase(antarctica);
		
		Continent oceanica = new Continent("Oceanica",9000000);
		continentService.saveContinentToDatabase(oceanica);
		Country australia = new Country("Australia",oceanica);
		countryService.saveContryToDatabase(australia);
		CapitalCity kanbera = new CapitalCity("Kanbera", 10000000, australia);
		cityService.saveCapitalCityToDatabase(kanbera);
		australia.setCapitalCity(kanbera);
		countryService.updateCountryOnDatabase(australia);
		
		
		
		
	}

}
