'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('ClustersCtrl', function ($scope, $http) {
    $http.get('/cluster/getAll')
      .then(function(response) {
        $scope.groups = response.data;
      });
  });

console.log("Im being run");




