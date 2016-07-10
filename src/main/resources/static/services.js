angular.module('app.services', []).factory('Product', function($resource) {
  return $resource('/product/:id', { id:'@id' }, {
    update: {
      method: 'PUT'
    }
  });
});