package edu.sabanciuniv.it526.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import edu.sabanciuniv.it526.entity.Continent;
import edu.sabanciuniv.it526.service.ContinentService;

@Named
@RequestScoped
public class ContinentBean {
	
	
	private List<Continent> continents;
	
	@Inject
	private ContinentService continentService;
	

	
	@PostConstruct
	public void initPage() {
		//if(continentService.getAllContinents().isEmpty()) {
		//existedContinents();
		//}
		this.continents = continentService.getAllContinents();
		
	}

	
	public List<Continent> getContinents() {
		return continents;
	}

	public void setContinents(List<Continent> continents) {
		this.continents = continents;
	}



}
