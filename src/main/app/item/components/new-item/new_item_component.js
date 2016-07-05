var module = require('main_module');

function Controller(ItemService) {
    var vm = this;

    vm.item = {};

    vm.create = function() {
      ItemService.create(vm.item).then(
        function(item) {
          console.log('Successfuly create item', item);
        });
    };
}

Controller.$inject = ['ItemService'];
require('new_item.scss');
//You can also require SASS files related to this component
module.component('itemNew', {
    controller: Controller,
    templateUrl: require('./new_item.html')
});
