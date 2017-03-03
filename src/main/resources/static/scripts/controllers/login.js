'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('LoginCtrl', function ($scope, $location, $http) {

    var formData = {
      name: "default",
      email: "default",
      address1: "default",
      address2: "",
      city: "default",
      state: "default",
      zip: "default",
      number: "default"
    };

    $scope.submit = function () {
      formData = $scope.form;
      $location.path('/dashboard');
      var url = ('/user/create?phoneNumber=' + formData.number + '&city=' + formData.city + '&state=' + formData.state + '&zip=' + formData.zip + '&address=' + formData.address1 + '&email=' + formData.email);
      console.log(url);
      $http.get(url).success(function (response) {
        console.log(response);
      }).error(function () {
        console.log('Could not create user');
      });
      return false;
    }

  })
  .controller("home", function ($http) {
    var self = this;
    $http.get("/user/test").success(function (data) {
      self.user = data.userAuthentication.details.name;
      self.authenticated = true;
    }).error(function () {
      self.user = "N/A";
      self.authenticated = false;
    });
  })
  .controller("UserCreationCtrl", function ($scope, $http) {
    var phoneNumber = document.getElementsByName("Phone Number")[0].value
    var city = document.getElementsByName("City")[0].value
    var state = document.getElementsByName("State")[0].value
    var zipCode = document.getElementsByName("Zip Code")[0].value
    var address = document.getElementsByName("Address")[0].value
    var url = ('localhost:8080/user/create?phoneNumber=' + phoneNumber + '&city=' + city + '&state=' + state + '&zip=' + zipCode + '&address=' + address);
    var isCreated = $http.get(url)
      .then(function(response) {
        //$scope.data = response.data;
        alert(isCreated);
      })
  });

function createUser() {
  var phoneNumber = document.getElementsByName("Phone Number")[0].value
  var city = document.getElementsByName("City")[0].value
  var state = document.getElementsByName("State")[0].value
  var zipCode = document.getElementsByName("Zip Code")[0].value
  var address = document.getElementsByName("Address")[0].value
  var url = ('localhost:8080/user/create?phoneNumber=' + phoneNumber + '&city=' + city + '&state=' + state + '&zip=' + zipCode + '&address=' + address);
}

  /*function uPost() {
    var parameter,
      data = 'parameters',config='contenttype',
      phoneNumber = document.getElementsByName("Phone Number")[0].value,
      city = document.getElementsByName("City")[0].value,
      state = document.getElementsByName("State")[0].value,
      zipCode = document.getElementsByName("Zip Code")[0].value,
      address = document.getElementsByName("Address")[0].value,
      url = ('localhost:8080/user/create?phoneNumber=' + phoneNumber + '&city=' + city + '&state=' + state + '&zip=' + zipCode + '&address=' + address);

      parameter = JSON.stringify({type:"text", phoneNumber: phoneNumber, city: city, state: state, zipCode: zipCode, address: address});
      var response = $http.get(url, parameter).
      success(function(data, status, headers, config) {
        console.log(data);
      }).
      error(function(data, status, headers, config) {
      });
    }*/





//'localhost:8080/user/create?phoneNumber=1234&city=Palo Alto&state=California&zip=94306&address=680 Georgia Ave'
