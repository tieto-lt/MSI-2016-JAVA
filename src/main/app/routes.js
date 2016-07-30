var module = require('main_module');

module.config(function($stateProvider, $urlRouterProvider) {

  // For any unmatched url, redirect to /
  $urlRouterProvider.otherwise("/");
  //
  // Now set up the states
  $stateProvider
    .state('home', {
      url: '/',
      template: '<h4>This is home of <a ui-sref="itemList">an item list</a>.</h4>'
    })
    .state('Login', {
      url: '/login',
      template: '<p>This is login page</p>'
    })
    .state('itemList', {
      url: '/items',
      template: '<item-list></item-list>'
    })
    .state('itemNew', {
      url: '/items/new',
      template: '<item-new></item-new>'
    })
    .state('itemDetails', {
      url: '/items/:id',
      template: '<item-details></item-details>'
    });
});
