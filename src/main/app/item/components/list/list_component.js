
var module = require('main_module');

function Controller() {
    //Convention to call controller instance 'vm'
    var vm = this;

    vm.items = [
      {
        id: 1,
        name: 'Item 1',
        quantity: '5',
        size: '2x2'
      },
      {
        id: 2,
        name: 'Item 2',
        quantity: '2',
        size: '2x213'
      },
      {
        id: 3,
        name: 'Item 3',
        quantity: '10',
        size: '2x66'
      }
    ];
}

module.component('itemList', {
    controller: Controller,
    templateUrl: require('./list.html')
});
