package com.circle.dao;

import java.util.List;

import com.circle.model.Country;

public interface CountryDao {

Country findById(long id);
	
	Country findByName(String name);
	
	void saveCountry(Country country);
	
	void updateCountry(Country country);
	
	void deleteCountryById(long id);

	List<Country> findAllCountries(); 
	
	void deleteAllCountries();
	
	public boolean isCountryExist(Country country);
}
