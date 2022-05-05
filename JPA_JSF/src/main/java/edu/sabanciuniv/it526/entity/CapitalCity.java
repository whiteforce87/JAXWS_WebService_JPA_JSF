package edu.sabanciuniv.it526.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CapitalCity extends City {
	
	@OneToOne
	private Country country;
	
	
	public CapitalCity() {
		super();
	}


	
	public CapitalCity(String name, int population, Country country) {
		super(name, population);
		this.country = country;
	}

	public CapitalCity(String name, int population) {
		super(name, population);
		
	}
	
	


	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "CapitalCity [country=" + country + "]";
	}

}
