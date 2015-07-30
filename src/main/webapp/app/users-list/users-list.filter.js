(function () {
  'use strict';

  angular
    .module('app.usersList')
    .filter('msiAwesome', AwesomeFilter);

  function AwesomeFilter() {
    return function(input) {
      return 'AWESOME ' + input;
    }
  }

})();