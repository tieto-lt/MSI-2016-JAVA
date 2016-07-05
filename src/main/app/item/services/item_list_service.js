var module = require('main_module');

function Service($http, $q) {

  this.get = function(id) {
    return $http.get('item/services/items.json').then(
      function(response) {
        return response.data.filter(function(item) {
          return item.id === id;
        })[0];
      }
    );
  };

  this.all = function() {
    return $http.get('item/services/items.json');
  };

  this.update = function(item) {
    var d = $q.defer();
    d.resolve(item);
    return d.promise;
  };

  this.create = function(item) {
    var d = $q.defer();
    d.resolve(item);
    return d.promise;
  };

  this.remove = function(id) {
    var d = $q.defer();
    d.resolve(id);
    return d.promise;
  };
}

Service.$inject = ['$http', '$q'];
module.service('ItemService', Service);
