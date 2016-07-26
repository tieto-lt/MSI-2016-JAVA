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
      data: {
        isPublic: true
      }
    })
    .state('login', {
      url: "/login",
        template: "<login></login>",
        data: {
          isPublic: true
        }
    })
    .state('itemList', {
      url: "/items",
      template: "<item-list></item-list>"
    })
    .state('itemNew', {
      url: "/items/new",
      template: "<item-new></item-new>"
    })
    .state('ItemDetails', {
      url: "/items/:id",
      template: "<item-details></item-details>"
    });
});


module.run(['$transitions', 'Session', '$state', function($transitions, Session, $state) {

  Session.initHttp();

  $transitions.onStart(
      {
        to: function (state) { return !state.data || !state.data.isPublic; }
      },
      function () {
        if (!Session.isSessionActive()) {
          return $state.target("login");
        }
      });
}]);
