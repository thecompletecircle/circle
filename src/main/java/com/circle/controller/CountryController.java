package com.circle.controller;
 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.circle.model.Country;
import com.circle.service.CountryService;
 
@RestController
public class CountryController {
 
    @Autowired
    CountryService countryService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Country--------------------------------------------------------
     
    @RequestMapping(value = "/country/", method = RequestMethod.GET, headers = {"Accept=text/xml, application/json"})
    public ResponseEntity<List<Country>> listAllCountry() {
        List<Country> country = countryService.findAllCountries();
        if(country.isEmpty()){
            return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Country>>(country, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Country--------------------------------------------------------
     
    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Country> getCountry(@PathVariable("id") long id) {
        System.out.println("Fetching Country with id " + id);
        Country country = countryService.findById(id);
        if (country == null) {
            System.out.println("Country with id " + id + " not found");
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Country--------------------------------------------------------
     
    @RequestMapping(value = "/country/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCountry(@RequestBody Country country,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Country " + country.getName());
 
        if (country.getName()==null || countryService.isCountryExist(country)) {
            System.out.println("A Country with name " + country.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        countryService.saveCountry(country);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/country/{id}").buildAndExpand(country.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Country --------------------------------------------------------
     
    @RequestMapping(value = "/country/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Country> updateCountry(@PathVariable("id") long id, @RequestBody Country country) {
        System.out.println("Updating Country " + id);
         
        Country currentCountry = countryService.findById(id);
         
        if (currentCountry==null) {
            System.out.println("Country with id " + id + " not found");
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }
 
        currentCountry.setName(country.getName());
        currentCountry.setCode(  country.getCode());
        currentCountry.setIsocode(  country.getIsocode());

        currentCountry.setDescr(country.getDescr());
        currentCountry.setLattitude(country.getLattitude());
        currentCountry.setLongitude(country.getLongitude());
        currentCountry.setCapital(country.getCapital());
        currentCountry.setCreatedAt(new Date());
        currentCountry.setUpdatedAt(new Date());
        currentCountry.setCreatedBy("Abhishek");
         //Set user datails
        countryService.updateCountry(currentCountry);
        return new ResponseEntity<Country>(currentCountry, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Country --------------------------------------------------------
     
    @RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Country> deleteCountry(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Country with id " + id);
 
        Country country = countryService.findById(id);
        if (country == null) {
            System.out.println("Unable to delete. Country with id " + id + " not found");
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }
 
        countryService.deleteCountryById(id);
        return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Countries --------------------------------------------------------
     
    @RequestMapping(value = "/country/", method = RequestMethod.DELETE)
    public ResponseEntity<Country> deleteAllCountries() {
        System.out.println("Deleting All Countries");
 
        countryService.deleteAllCountries();
        return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
    }
   
}