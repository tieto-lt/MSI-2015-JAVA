(function (angular) {
  'use strict';

  angular
    .module('MSI-app')
    .config(function($httpProvider) {
	  
	  $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  	})
  	.config(function($stateProvider, $urlRouterProvider) {
  //
  // For any unmatched url, redirect to /state1
  $urlRouterProvider.otherwise("/login");
  //
  // Now set up the states
  $stateProvider
    .state('login', {
    	url: "/login",
        templateUrl: "loginPage.tmpl.html"
      
    })
    .state('state2', {
      url: "/app/profile_header",
      templateUrl: "app/profile_header/profile_header.tmpl.html"
    });
});

})(window.angular);