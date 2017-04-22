'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('AdminCtrl', function ($scope, $http, $state) {
    $http.get('/admin/getNumActiveUsers')
      .then(function (response) {
        $scope.activeUsers = response.data;
      });
    $http.get('/admin/getNumActiveClusters')
      .then(function (response) {
        $scope.activeClusters = response.data;
      });
    $http.get('/cluster/getAll')
      .then(function (response) {
        $scope.groups = response.data;
      });

    $scope.disband = function (clusterId) {
      var url = ('admin/disbandCluster?clusterId=' + clusterId);
      $http.get(url).success(function (response) {
        if (response) {
          $state.reload();
        } else {
          alert("Could not disband cluster!");
        }
      }).error(function () {
        console.log("Something went wrong with disbanding the cluster. Check the console!");
        return false;
      });
    };

  });




