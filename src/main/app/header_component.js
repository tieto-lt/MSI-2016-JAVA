var module = require('main_module');

function Controller() {
  var vm = this;

  vm.value = "This is my OSOM header";
  
}
var templateUrl = require('./header.html');
require('header.scss');
module.component('msiHeader', {
    templateUrl: templateUrl,
    controller: Controller
});
