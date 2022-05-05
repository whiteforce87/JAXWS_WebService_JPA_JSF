package edu.sabanciuniv.it526.util;

import java.util.List;

import edu.sabanciuniv.it526.entity.Country;


public class ServiceResponse {
	
	private int responseCode;
	private String responseMessage;
	private Object details;
	private List<Country> allResults;
	
	public ServiceResponse() {
		super();
	}
	public ServiceResponse(int responseCode, String responseMessage, Object details) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.details = details;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	public ServiceResponse(Object details, List<Country> allResults) {
		super();
		this.details = details;
		this.allResults = allResults;
	}
	@Override
	public String toString() {
		return "ServiceResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + ", details="
				+ details + "]";
	}
	public List<Country> getAllResults() {
		return allResults;
	}
	public void setAllResults(List<Country> allResults) {
		this.allResults = allResults;
	}
	
}
