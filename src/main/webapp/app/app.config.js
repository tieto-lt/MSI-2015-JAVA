(function (angular) {
  'use strict';

  angular
    .module('MSI-app')
    .config(function($httpProvider) {
	  
	  $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  	});

})(window.angular);