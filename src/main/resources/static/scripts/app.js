'use strict';

/**
 * @ngdoc overview
 * @name yapp
 * @description
 * # yapp
 *
 * Main module of the application.
 */
angular
  .module('yapp', [
    'ui.router',
    'ngAnimate'
  ])
  .config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.when('/dashboard', '/dashboard/overview');
    $urlRouterProvider.otherwise('/login');

    $stateProvider
      .state('base', {
        abstract: true,
        url: '',
        templateUrl: 'views/base.html'
      })
      .state('login', {
        url: '/login',
        parent: 'base',
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
      })
      .state('dashboard', {
        url: '/dashboard',
        parent: 'base',
        templateUrl: 'views/dashboard.html',
        controller: 'DashboardCtrl'
      })
      .state('overview', {
        url: '/overview',
        parent: 'dashboard',
        templateUrl: 'views/dashboard/overview.html'
      })
      .state('clusters', {
        url: '/clusters',
        parent: 'dashboard',
        templateUrl: 'views/dashboard/clusters.html'
      })
      .state('profile', {
        url: '/profile',
        parent: 'dashboard',
        templateUrl: 'views/dashboard/profile.html'
      })
      .state('createCluster', {
        url: '/createCluster',
        parent: 'dashboard',
        templateUrl: 'views/dashboard/cluster-form.html'
      })
      .state('admin', {
        url: '/admin',
        parent: 'dashboard',
        templateUrl: 'views/dashboard/admin.html'
      })
      .state('myCluster', {
        url: '/myCluster',
        parent: 'dashboard',
        templateUrl: 'views/dashboard/my-cluster.html'
      })
      .state('rating', {
        url: '/rating',
        parent: 'dashboard',
        templateUrl: 'views/dashboard/rating.html'
      })
  });
