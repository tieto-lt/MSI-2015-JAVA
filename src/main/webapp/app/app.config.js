(function (angular) {
  'use strict';

  angular
    .module('MSI-app')
    .config(function($httpProvider) {
	  
	  $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  	})
  	.config(function($stateProvider, $urlRouterProvider) {

  		$urlRouterProvider.otherwise("/login");

		$stateProvider
			.state('login', {
		    	url: "/login",
		        templateUrl: "loginPage.tmpl.html"
		      
		    })
		    .state('registration', {
		    	url: "/registration",
		    	templateUrl: "registrationPage.tmpl.html"
		    })
		    .state('userpage', {
		    	url: "/userpage",
		    	templateUrl: "userPage.tmpl.html"
		    });
		});

})(window.angular);