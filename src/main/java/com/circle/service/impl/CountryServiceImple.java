package com.circle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.circle.dao.CountryDao;
import com.circle.model.Country;
import com.circle.service.CountryService;

@Service("countryrService")
@Transactional
public class CountryServiceImple implements CountryService{
	
	@Autowired
	private CountryDao countryDao;
	
	public List<Country> findAllCountries() {
		return countryDao.findAllCountries();
	}
	
	@Override
	public Country findById(long id) {
		
		return countryDao.findById(id);
	}
	@Override
	public Country findByName(String userName) {
		return countryDao.findByName(userName);
	}
	@Override
	public void saveCountry(Country country) {
		countryDao.saveCountry(country);
	}
	@Override
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);
	}
	@Override
	public void deleteCountryById(long id) {

		countryDao.deleteCountryById(id);
	}

	@Override
	public boolean isCountryExist(Country country) {
		return findByName(country.getName())!=null;
	}
	@Override
	public void deleteAllCountries(){
		countryDao.deleteAllCountries();
	}

 

	 
}
