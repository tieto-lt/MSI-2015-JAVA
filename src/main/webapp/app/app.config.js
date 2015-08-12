(function (angular) {
  'use strict';

  angular
    .module('MSI-app')
    .config(function($httpProvider) {
	  
	  $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  	})
  	
  	/*
  	 * UI-router
  	 */  	
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
		    .state('adminPage', {
		    	url: "/admin",
		    	templateUrl: "adminPage.tmpl.html"
		    })
		    .state('userPage', {
		    	url: "/user",
		    	templateUrl: "userPage.tmpl.html"
		    })
			.state('logout', {
		    	url: "/logout",
		    	templateUrl: "loginPage.tmpl.html"
		    });
		});

})(window.angular);