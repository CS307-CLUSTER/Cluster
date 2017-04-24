'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:ClustersCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('ClustersCtrl', function ($scope, $http, $location, $state) {
    $http.get('/cluster/getAll')
      .then(function (response) {
        $scope.groups = response.data;
      });

    $http.get('/cluster/getCurrent')
      .then(function (response) {
        $scope.currentCluster = response.data;
        if ($scope.currentCluster) {
          $scope.hasCluster = true;
        } else {
          $scope.hasCluster = false;
        }
      });

    $http.get('/restaurant/getAll')
      .then(function (response) {
        $scope.restaurants = response.data;
        if ($scope.restaurants == null) {
          console.log("No Restaurants");
        } else {
          console.log("There are restaurants");
          console.log($scope.restaurants);
        }
      });

    $http.get('/user/getId')
      .then(function (response) {
        if ($scope.currentCluster == null) {
          $scope.isLeader = false;
        } else {
          $scope.isLeader = response.data == parseFloat($scope.currentCluster.leaderID);
        }
      });

    var formData = {
      restaurant: "default",
      maxUsers: "default",
      minUsers: "default",
      startTime: "default",
      endTime: "default",
      address1: "default",
      address2: "default",
      city: "default",
      state: "default",
      zip: "default"
    };

    $scope.update = function() {
      $scope.restaurantId = $scope.form.restaurant.id;
      console.log("ID: " + $scope.restaurantId);
    }

    $scope.submit = function () {
      console.log("I've ran");
      formData = $scope.form;
      $location.path('/dashboard/clusters');
      var url = ('/cluster/create?restaurant_id=' + $scope.restaurantId + '&maxUsers=' + formData.maxUsers + '&minUsers=' + formData.minUsers +
      '&address=' + formData.address1 + '&city='
      + formData.city + '&state=' + formData.state + '&zip=' + formData.zip);
      console.log(url);
      $http.get(url).success(function (response) {
        console.log(response);
      }).error(function () {
        console.log('Could not create cluster');
      });
      return false;
    };

    $scope.join = function (clusterId) {
      var url = ('cluster/join?clusterId=' + clusterId);
      console.log("Join function ran on clusterId: " + clusterId);
      $http.get(url).success(function (response) {
        if (response) {
          console.log("Added user to cluster " + clusterId);
          $state.reload();
        } else {
          alert("Could not join cluster! Check if you are already in one!");
        }
      }).error(function () {
        console.log("hmmm... something went wrong with adding user to cluster. Check console!");
        return false;
      });
    };

    $scope.leave = function () {
      var getUserUrl = ('user/info');
      var clusterId = '-1';
      $http.get(getUserUrl).success(function (response) {
        clusterId = response['currentClusterId'];
        $scope.currentClusterId = clusterId;
        var leaveUrl = ('cluster/leave?clusterId=' + clusterId);
        $http.get(leaveUrl).success(function (response) {
          if (response) {
            console.log("User removed from cluster " + clusterId);
            $state.reload();
          } else {
            alert("Could not leave a cluster! Check if you are in a cluster!");
          }
        }).error(function () {
          console.log("Error removing user from cluster " + clusterId);
        });

      }).error(function () {
        console.log("Error retreiving user for leave function");
        return false;
      });
    };

    $scope.removeUser = function (userId) {
      console.log("I worked");
      var clusterId = '-1';
      var getUserUrl = ('user/info');
      $http.get(getUserUrl).success(function (response) {
        clusterId = response['currentClusterId'];
        var kickUrl = ('cluster/kick?userId=' + userId + "&clusterId=" + clusterId);
        $http.get(kickUrl).success(function (response) {
          if (response) {
            console.log("Success, user has been kicked " + userId);
            $state.reload();
          } else {
            alert("Cannot kick user!");
          }
        }).error(function () {
          console.log("I dont know what happened...");
        });
      }).error(function () {
        console.log("Error!!!");
        return false;
      });
    };

    $scope.complete = function(clusterId) {
      var completeUrl = ('cluster/complete?clusterId=' + clusterId);
      $http.get(completeUrl).success(function (response) {
        console.log("Should have completed");
      });
      $state.reload();
    }
  });




