'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('DashboardCtrl', function($scope, $state, $http, $location) {

    $scope.$state = $state;

    $scope.logout = function() {
      console.log("Logout ran");
      $http.post('/logout', {}).success(function() {
        self.authenticated = false;
        $location.path("/");
      }).error(function(data) {
        console.log("Logout failed")
        self.authenticated = false;
      });
    };
  });
/*
  .controller("AdminTabCtrl", function ($http) {
    var self = this;
    $http.get("/user/test").success(function (data) {
      self.user = data.userAuthentication.details.name;
      self.authenticated = true;
    }).error(function () {
      self.user = "N/A";
      self.authenticated = false;
    });
  })
  */
