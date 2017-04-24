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
        var userIds = response.data;
        var i;
        var users = [];
        for (i = 0; i < userIds.length; i++) {
          $http.get('/user/getById?userId=' + userIds[i])
            .then(function (response2) {
              users.push(response2.data);
              console.log(response2.data);
            })
        }
        $scope.group = users;
      });


    //-------------------------------------------------------------

    $scope.upVote = function (userId) {
      // console.log("upvoted");
      // $http.get().success(function () {
      //   return true;
      // })

      console.log("Upvoted Ran");

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

    $scope.downVote = function (userId) {
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

    /**document.addEventListener("DOMContentLoaded", function() {
      console.log("changed");
      var IDlist = document.getElementById(userId);
      var resultList = [];
      var i = 0;
      var url = ('/user/rating?userId=' + userId);
      while (i < IDlist.rows.length) {
        resultList[i] = $http.get(url).success(function (response) {
          console.log(response);
        }).error(function () {
          console.log('Could not convert');
        });
      }
    })**/
  });



