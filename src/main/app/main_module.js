require('angular');
require('angular-ui-router');
require('angular-messages');
require('angular-cookies');
require('angular-jwt');

require("bootstrap/dist/css/bootstrap.css");

var _module = angular.module('MsiApp', ['ui.router', 'ngMessages', 'ngCookies', 'angular-jwt']);

module.exports = _module;
