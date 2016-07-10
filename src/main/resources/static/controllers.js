angular.module('app.controllers', []).controller('ProductListController', function($scope, $state, $window, Product) {
  $scope.products = Product.query(); 

  $scope.deleteProduct = function(product) {
      product.$delete(function() {
        $window.location.href = ''; //redirect to home
      });
  };
}).controller('ProductViewController', function($scope, $stateParams, Product) {
  $scope.product = Product.get({ id: $stateParams.id });
}).controller('ProductCreateController', function($scope, $state, $stateParams, Product) {
  $scope.product = new Product();

  $scope.addProduct = function() {
    $scope.product.$save(function() {
      $state.go('index');
    });
  };
}).controller('ProductEditController', function($scope, $state, $stateParams, Product) {
  $scope.updateProduct = function() {
    $scope.product.$update(function() {
      $state.go('index');
    });
  };

  $scope.loadProduct = function() {
    $scope.product = Product.get({ id: $stateParams.id });
  };

  $scope.loadProduct();
});