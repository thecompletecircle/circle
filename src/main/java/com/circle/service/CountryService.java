package com.circle.service;

import java.util.List;

import com.circle.model.Country;

public interface CountryService {
	
	Country findById(long id);
	
	Country findByName(String name);
	
	void saveCountry(Country country);
	
	void updateCountry(Country country);
	
	void deleteCountryById(long id);

	List<Country> findAllCountries(); 
	
	void deleteAllCountries();
	
	public boolean isCountryExist(Country country);
}
