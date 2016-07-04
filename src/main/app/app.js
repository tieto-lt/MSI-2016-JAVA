(function () {
  'use strict';

  require('style.css');

  window.hideElement = function() {
    var element = document.getElementById('hide-me');
    element.style.display = "none";
  };

})();
