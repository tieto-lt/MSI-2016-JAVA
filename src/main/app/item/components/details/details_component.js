var module = require('main_module');

module.component('itemDetails', {
    controller: Controller,
    templateUrl: require('./details.html')
});

Controller.$inject = ['$state', '$stateParams', 'ItemService'];

function Controller($state, $stateParams, ItemService) {
    //Controller body goes here

    var vm = this;

    vm.item = {};
    vm.itemId = parseInt($stateParams.id);
    vm.errors = [];

    vm.update = update;
    vm.remove = remove;

    vm.$onInit = function() {
        _loadItem();
    };

    function update() {
        ItemService.update(vm.item).then(
            function () { console.log('Update success'); },
            function (err) {
                if (err.status === 400) {
                    vm.errors = err.data;
                } else {
                    console.log('Error', err);
                }
            });
    }

    function remove() {
        ItemService.remove(vm.itemId).then(
            function () { $state.go('itemList'); },
            function (err) {
                console.log('Error', err);
            });
    }

    function _loadItem() {
        if (vm.itemId) {
            ItemService.get(vm.itemId).then(
                function (response) {
                    vm.item = response;
                    console.log(vm.item);
                },
                function (err) {
                    console.log('Error', err);
                });
        }
    }
}


