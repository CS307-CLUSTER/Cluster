'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('ProfileCtrl', function ($scope, $http) {
    $http.get('/user/info')
      .then(function(response) {
        $scope.data = response.data;
      });
  });

console.log("Im being run");
