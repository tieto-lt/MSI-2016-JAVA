var module = require('main_module');

module.config(function($stateProvider, $urlRouterProvider) {

  // For any unmatched url, redirect to /
  $urlRouterProvider.otherwise("/");
  //
  // Now set up the states
  $stateProvider
    .state('home', {
      url: '/',
      template: "<h4>This is home</h4>",
    })
    .state('Login', {
      url: "/login",
      template: "<p>This is login page</p>",
    })
    .state('itemList', {
      url: "/items",
      template: "<p>Items</p><a ui-sref=\"itemNew\">Navigate</a>"
    })
    .state('itemNew', {
      url: "/items/new",
      template: "<p>New Item</p>"
    })
    .state('ItemDetails', {
      url: "/items/:id",
      template: "<p>Item Details</p>"
    });
});
