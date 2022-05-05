package edu.sabanciuniv.it526.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;


	@ManyToOne
	private Continent continent;
	
	@OneToMany(mappedBy = "country")
	private List<City> cities;
	
	@OneToOne
	private CapitalCity capitalCity;
	
	
	public Country() {
		super();
	}

	public Country(String name) {
		super();
		this.name = name;
	}

	public Country(String name, Continent continent) {
		super();
		this.name = name;
		this.continent = continent;
	}
	


	public Country(String name, Continent continent, List<City> cities, CapitalCity capitalCity) {
		super();
		this.name = name;
		this.continent = continent;
		this.cities = cities;
		this.capitalCity = capitalCity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public List<City> getCities() {
		if(this.cities == null)
			this.cities = new ArrayList<City>();
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public CapitalCity getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(CapitalCity capitalCity) {
		this.capitalCity = capitalCity;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", continent=" + continent + ", cities=" + cities
				+ ", capitalCity=" + capitalCity + "]";
	}


}
