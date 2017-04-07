
'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:OtherProfileCtrl
 * @description
 * # OtherProfileCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('OtherProfileCtrl', function ($scope, $http) {
    $http.get('/user/info') //  <--   fix this path
      .then(function (response) {
        $scope.data = response.data;
      });
  });
