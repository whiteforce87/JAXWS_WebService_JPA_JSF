package edu.sabanciuniv.it526.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int population;
	

	@ManyToOne
	private Country country;
	
	
	public City() {
		super();
	}


	public City( String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}


	public City(String name, int population, Country country) {
		super();
		this.name = name;
		this.population = population;
		this.country = country;
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


	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", population=" + population + ", country=" + country + "]";
	}

	

}
