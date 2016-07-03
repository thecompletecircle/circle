'use strict';

App.factory('CountryService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllCountries: function() {
					return $http.get('http://localhost:8080/Circle/country/')
							.then(
									function(response){
										 console.log(response.data);
		                                    console.table(response.data);
										return response.data;
									}, 
									function(errResponse){
										 console.log(errResponse);
 										console.error('Error while fetching countrys');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createCountry: function(country){
					return $http.post('http://localhost:8080/Circle/country/', country)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating country');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateCountry: function(country, id){
					return $http.put('http://localhost:8080/Circle/country/'+id, country)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating country');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteCountry: function(id){
					return $http.delete('http://localhost:8080/Circle/country/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting country');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
