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
      .then(function(data, status) {
        $scope.response = data;
        var user = JSON.parse(data);
        $scope.name = user.name;
      });
  });

console.log("Im being run");
