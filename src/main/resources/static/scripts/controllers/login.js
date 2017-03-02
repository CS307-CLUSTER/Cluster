'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('LoginCtrl', function ($scope, $location) {

    $scope.submit = function () {

      $location.path('/dashboard');

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
  });
