var module = require('main_module');

function Controller() {
    //Controller body goes here

    var vm = this;


}


module.component('itemDetails', {
    controller: Controller,
    templateUrl: require('./details.html')
});
