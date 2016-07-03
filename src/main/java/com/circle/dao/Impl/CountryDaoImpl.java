package com.circle.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.circle.dao.AbstractDao;
import com.circle.dao.CountryDao;
import com.circle.model.Country;

@Repository("CountryDao")
public class CountryDaoImpl  extends AbstractDao<Long, Country> implements CountryDao{

	
	 @Autowired
	    private SessionFactory sessionFactory;
	 protected Session getSession(){
	        return sessionFactory.getCurrentSession();
	    }
	 
	 
	@Override
	public Country findById(long id) {
		return getByKey(id);
	}

	@Override
	public Country findByName(String name) {
	Query query = getSession().createQuery("from Country where name=:countryName");
	query.setString("countryName",name);
		return (Country) query.uniqueResult();
	}

	@Override
	public void saveCountry(Country country) {
		persist(country);
		
	}

	@Override
	public void updateCountry(Country country) {
		update(country);
		
	}

	@Override
	public void deleteCountryById(long id) {
		delete(id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> findAllCountries() {
		 Criteria criteria = createEntityCriteria();
	        return (List<Country>) criteria.list();
	}

	@Override
	public void deleteAllCountries() {
		deleteAllCountries();
		
	}

	@Override
	public boolean isCountryExist(Country country) {
		List<Country> list = new ArrayList<>();
	list= get(country);
	 
return list.isEmpty();
	}

}
