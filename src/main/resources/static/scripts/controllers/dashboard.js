'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('DashboardCtrl', function($scope, $state, $http, $location, $window) {

    $scope.$state = $state;

    $http.get("/user/isBanned").then(function (response) {
      $scope.isBanned = response.data;
      console.log(response.data);
    });

    $scope.logout = function() {
      console.log("Logout ran");
      $http.post('/logout', {}).success(function() {
        self.authenticated = false;
        $location.path("/");
      }).error(function(data) {
        console.log("Logout failed");
        self.authenticated = false;
      });
    };

    // $scope.banRedirect = function() {
    //   $window.location.href="../../ban.html";
    // }
  })

  .controller("AdminTabViewCtrl", function ($http, $scope) {
    $scope.isAdmin = checkAdmin();
    console.log($scope.isAdmin);

    function checkAdmin() {
      return $http.get("/user/isAdmin").success(function (data) {
        $scope.isAdmin = data;
        console.log($scope.isAdmin);
        return true;
      });
    }
  });

