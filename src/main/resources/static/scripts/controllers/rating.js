/**
 * Created by DavidTong on 4/7/17.
 */


'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:RatingCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
angular.module('yapp')
  .controller('RatingCtrl', function ($scope, $http, $location, $state) {
    $http.get('/rating/getAll')
      .then(function (response) {
        $scope.groups = response.data;
      });

    //-------------------------------------------------------------

    $scope.upvote = function () {
      console.log("upvoted");
      $http.get('/user/upVote').success(function () {
        return true;
      })


      console.log(url);
      $http.get(url).success(function (response) {
        console.log(response);
      }).error(function () {
        console.log('Could not upvote');
      });
      return false;
    };

    //-------------------------------------------------------------

    $scope.downvote = function () {
      console.log("downvoted");
      $location.path('/user/downVote');


      console.log(url);
      $http.get(url).success(function (response) {
        console.log(response);
      }).error(function () {
        console.log('Could not downvote');
      });
      return false;
    };
  });



