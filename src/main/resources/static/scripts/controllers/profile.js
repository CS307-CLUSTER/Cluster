'use strict';

/**
 * @ngdoc function
 * @name yapp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of yapp
 */
var newData = null;

angular.module('yapp')


  .controller('ProfileCtrl', function ($scope, $http) {
    $http.get('/user/info')
      .then(function (response) {
        $scope.data = response.data;
        newData = $scope.data;
      });

    console.log($scope.data);
  })


  .directive("clickToEdit", function () {
    var editorTemplate = '' +
      '<div class="container">' +
      '<div ng-hide="view.editorEnabled">' +
      '{{value}} ' +
      '<a class="btn btn-primary btn-outline btn-rounded" ng-click="enableEditor()">Edit</a>' +
      '</div>' +
      '<div ng-show="view.editorEnabled">' +
      '<input type="text" class="small-12.columns" ng-model="view.editableValue">' +
      '<a class="btn btn-primary btn-outline btn-rounded" href="#" ng-click="save()">Save</a>' +
      ' or ' +
      '<a class="btn btn-primary btn-outline btn-rounded" ng-click="disableEditor()">Cancel</a>' +
      '</div>' +
      '</div>';

    return {
      restrict: "A",
      replace: true,
      template: editorTemplate,
      scope: {
        structure: "=structure",
        value: "=clickToEdit"
      },
      link: function (scope, element, attrs) {
        scope.view = {
          editableValue: scope.value,
          editorEnabled: false
        };

        scope.enableEditor = function () {
          scope.view.editorEnabled = true;
          scope.view.editableValue = scope.value;
          setTimeout(function () {
            element.find('input')[0].focus();
            //element.find('input').focus().select(); // w/ jQuery
          });
        };

        scope.disableEditor = function () {
          scope.view.editorEnabled = false;
        };

        scope.save = function () {
          scope.value = scope.view.editableValue;
          scope.disableEditor();
          console.log(scope.value);
          console.log(scope.value);
        };
      }
    };
  });

console.log("Im being run");
