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
  })
  .controller("AdminTabViewCtrl", function ($http) {
    var self = this;
    $http.get("/user/isAdmin").success(function (data) {
      self.isAdmin = data;
    }).error(function () {
      console.log('error');
      self.isAdmin = false;
    });
  });
