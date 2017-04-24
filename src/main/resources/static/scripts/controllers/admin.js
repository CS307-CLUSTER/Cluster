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
    $http.get('/admin/getNumCompletedClusters')
      .then(function (response) {
        $scope.numCompleted = response.data;
      });
    $http.get('/admin/getNumNotCompletedClusters')
      .then(function (response) {
        $scope.numNotCompleted = response.data;
      });
    $http.get('/user/getAll')
      .then(function (response) {
        $scope.users = response.data;
      });
    $http.get('/cluster/getAll')
      .then(function (response) {
        $scope.groups = response.data;
      });
    $http.get('/admin/getAllClusterHistory')
      .then(function (response) {
        var clusterHistory = response.data;
        // var i;
        // for (i = 0; i < clusterHistory.length; i++) {
        //   //current.restaurant_id = getRestaurant(current.restaurant_id);
        //   var leaderName = getUser(clusterHistory[i].leader_id);
        //   var index = i;
        //   leaderName.then(function(result) {
        //     clusterHistory[index]["leader_name"] = result.name;
        //     console.log(clusterHistory[index].leader_name);
        //   })
        // }
        $scope.clusterHistory = clusterHistory;
        console.log($scope.clusterHistory);
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

    $scope.view = function (userId) {
      var url = ('admin/getUserInformation?userId=' + userId);
      console.log(url);
      $http.get(url).success(function (response) {
        if (response) {
          $state.reload();
        } else {
          alert("Could not view profile!");
        }
      }).error(function () {
        console.log("Something went wrong with viewing profile. Check the console!");
        return false;
      });
    };

    var getUser = function (userId) {
      var url = ('user/getById?userId=' + userId);
      console.log(url);
      return $http.get(url)
        .then(function (response) {
          return response.data.name;
        });
    };

    $scope.getUser = function (userId) {
      var leaderName = getUser(userId);
      leaderName.then(function(result) {
        console.log(result);
        return result;
      })
    };

    function getRestaurant(restaurantId) {
      var url = ('restaurant/get?id=' + restaurantId);
      console.log(url);
      $http.get(url).success(function (response) {
        if (response) {
          $state.reload();
        } else {
          alert("Could not get restaurant object!");
        }
      }).error(function () {
        console.log("Something went wrong with getting restaurant object. Check the console!");
        return false;
      });
    }

  });
