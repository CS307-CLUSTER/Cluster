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

    $scope.upvote = function (userId) {
      // console.log("upvoted");
      // $http.get().success(function () {
      //   return true;
      // })


      var url = ('/user/upVote?userId=' + userId);
      console.log(url);
      $http.get(url).success(function (response) {
        console.log(response);
      }).error(function () {
        console.log('Could not upvote');
      });
      return false;
    };

    //-------------------------------------------------------------

    $scope.downvote = function (userId) {
      console.log("downvoted");
      var url = ('/user/downVote?userId=' + userId);


      console.log(url);
      $http.get(url).success(function (response) {
        console.log(response);
      }).error(function () {
        console.log('Could not downvote');
      });
      return false;
    };
  });



