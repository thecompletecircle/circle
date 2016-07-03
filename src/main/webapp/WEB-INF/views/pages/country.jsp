<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Circle</title>  

     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="CountryController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Country Creation</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.country.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Country Name</label>
                              <div class="col-md-7">
                                <select ng-model="ctrl.country.name" ng-options="countryName for countryName in ctrl.countryNames">
								 <option value="">Please select</option>
								</select>


                                 <!--  <input type="text" ng-model="ctrl.country.name" name=name class="Countryname form-control input-sm" placeholder="Enter Country Name" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.name.$error.required">This is a required field</span>
                                      <span ng-show="myForm.name.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.name.$invalid">This field is invalid </span>
                                  </div> -->
                              </div>
                          </div>
                      </div>
                        
                      
                    <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Country Code</label>
                              <div class="col-md-7">
                            
                                  <input type="text" ng-model="ctrl.country.code" name="code"class="countrycode form-control input-sm" placeholder="Enter Country Code" required ng-minlength="1"/>
                             
                              <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.code.$error.required">This is a required field</span>
                                      <span ng-show="myForm.code.$error.minlength">Minimum length required is 1</span>
<!--                                       <span ng-show="myForm.code.$invalid">This field is invalid </span>
 -->                                  </div>
                              </div>
                          </div>
                      </div>
                       
 							<div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">ISO Code</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.country.isocode" name="isocode" class="isocode form-control input-sm" placeholder="Enter ISO Country code" required ng-minlength="2"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.isocode.$error.required">This is a required field</span>
                                      <span ng-show="myForm.isocode.$error.minlength">Minimum length required is 2</span>
<!--                                       <span ng-show="myForm.isocode.$invalid">This field is invalid </span>
 -->                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Description</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.country.descr" name="descr" class="countrydescr form-control input-sm" placeholder="Enter Description"/>
                              </div>
                          </div>
                      </div>
      <div class="row">

                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Lattitude</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.country.lattitude" name="lattitude" class="countrylattitude form-control input-sm" placeholder="Enter Lattitude" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.lattitude.$error.required">This is a required field</span>
                                      
                                  </div>
                              </div>
                          </div>
                      </div>
                       <div class="row">

                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Longitude</label>
                              <div class="col-md-7">
                                  <input  type="text" ng-model="ctrl.country.longitude" name="longitude" class="countrylongitude form-control input-sm" placeholder="Enter Longitude" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.longitude.$error.required">This is a required field</span>
                                      
                                  </div>
                              </div>
                          </div>
                      </div>
                       <div class="row">

                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Capital</label>
                              <div class="col-md-7">
                                  <input  type="text" ng-model="ctrl.country.capital" name="capital" class="countrycapital form-control input-sm" placeholder="Enter Capital" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.capital.$error.required">This is a required field</span>
                                      
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                     

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.country.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div> 
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Countries </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>ISO Code</th>
                              <th>Code</th>
                              <th>Capital</th>
                              <th>Latitude</th>
                              <th>Longitude</th>
                             
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.countries">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                               <td><span ng-bind="u.isocode"></span></td>
                              <td><span ng-bind="u.code"></span></td>
                                <td><span ng-bind="u.capital"></span></td>
                              <td><span ng-bind="u.lattitude"></span></td>
                                 <td><span ng-bind="u.longitude"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/countryService.js' />"></script>
      <script src="<c:url value='/static/js/controller/countryController.js' />"></script>
  </body>
</html>