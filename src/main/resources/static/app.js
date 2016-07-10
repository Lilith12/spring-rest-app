angular.module('app', ['ui.router', 'ngResource', 'app.services', 'app.controllers']);

angular.module('app').config(function($stateProvider) {
  $stateProvider.state('index', { 
    url: '/',
    templateUrl: 'products.html',
    controller: 'ProductListController'
  }).state('viewProduct', { 
    url: '/product/view/:id',
    templateUrl: 'product-view.html',
    controller: 'ProductViewController'
  }).state('newProduct', {
    url: '/product/new',
    templateUrl: 'product-add.html',
    controller: 'ProductCreateController'
  }).state('editProduct', { 
    url: '/product/edit/:id',
    templateUrl: 'product-update.html',
    controller: 'ProductEditController'
  });
}).run(function($state) {
  $state.go('index');
});