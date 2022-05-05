package edu.sabanciuniv.it526.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Continent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int area;
	

	@OneToMany(mappedBy = "continent")
	private List<Country> countries;
	
	
	public Continent() {
		super();
	}


	public Continent(String name, int area) {
		super();
		this.name = name;
		this.area = area;
	}



	public Continent(String name, int area, List<Country> countries) {
		super();
		this.name = name;
		this.area = area;
		this.countries = countries;
	}


	public int getArea() {
		return area;
	}


	public void setArea(int area) {
		this.area = area;
	}



	public List<Country> getCountries() {
		if(this.countries == null)
			this.countries = new ArrayList<Country>();
		return countries;
	}


	public void setCountries(List<Country> countries) {
		this.countries = countries;
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
		return "Continent [id=" + id + ", name=" + name + ", area=" + area + ", countries=" + countries + "]";
	}


}
