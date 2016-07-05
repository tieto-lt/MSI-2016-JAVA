
var module = require('main_module');

function Controller(ItemService) {
    //Convention to call controller instance 'vm'
    var vm = this;

    vm.items = [];

    vm.$onInit = function() {
      ItemService.all().then(function(response){
        vm.items = response.data;
      });
    };
}

Controller.$inject = ['ItemService'];

module.component('itemList', {
    controller: Controller,
    templateUrl: require('./list.html')
});
