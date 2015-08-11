(function (angular) {
  'use strict';

  angular
  	.module('app.login')
  	.config(function($httpProvider) {
	  
	  $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  	})
})(window.angular)