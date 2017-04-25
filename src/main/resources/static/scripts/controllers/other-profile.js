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
    $scope.showModal = false;
    $scope.buttonClicked = "";
    $scope.toggleModal = function (btnClicked, upVotes, downVotes, number, fbLink, email) {
      $scope.buttonClicked = btnClicked;
      $scope.upVotes = upVotes;
      $scope.downVotes = downVotes;
      $scope.number = number;
      $scope.fbLink = fbLink;
      $scope.email = email;
      $scope.showModal = !$scope.showModal;
    };
  })

  .directive('modal', function () {
    return {
      template: '<div class="modal fade">' +
      '<div class="modal-dialog">' +
      '<div class="modal-content">' +
      '<div class="modal-header">' +
      '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
      '<h4 class="modal-title">{{ buttonClicked }}</h4>' +
      '</div>' +
      '<div class="modal-body" style="align-center" ng-transclude></div>' +
      '<p>   Upvotes: {{ upVotes }}</p>' +
      '<p>   Downvotes: {{ downVotes }}</p>' +
      '<p>   Phone Number: {{ number }}</p>' +
      '<p>   Facebook Profile: <a ng-href="{{ fbLink }}"' +
      'class="glyphicon glyphicon-user"></a></p>' +
      '<p>   Email: {{ email }}</p>' +
      '</div>' +
      '</div>' +
      '</div>',
      restrict: 'E',
      transclude: true,
      replace: true,
      scope: true,
      link: function postLink(scope, element, attrs) {
        scope.$watch(attrs.visible, function (value) {
          if (value == true)
            $(element).modal('show');
          else
            $(element).modal('hide');
        });

        $(element).on('shown.bs.modal', function () {
          scope.$apply(function () {
            scope.$parent[attrs.visible] = true;
          });
        });

        $(element).on('hidden.bs.modal', function () {
          scope.$apply(function () {
            scope.$parent[attrs.visible] = false;
          });
        });
      }
    };
  });
