var module = require('main_module');

function Controller() {
    var vm = this;

    vm.item = {};

}
//You can also require SASS files related to this component
module.component('itemNew', {
    controller: Controller,
    templateUrl: require('./new_item.html')
});
