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
<<<<<<< HEAD
		    .state('adminPage', {
		    	url: "/admin",
		    	templateUrl: "adminPage.tmpl.html"
		    })
		    .state('userPage', {
		    	url: "/user",
		    	templateUrl: "userPage.tmpl.html"
		    })
		    .state('eshopPage', {
		    	url: "/eshop",
		    	templateUrl: "eshopPage.tmpl.html"
=======
		    .state('userpage', {
		    	url: "/userpage",
		    	templateUrl: "userPage.tmpl.html"
>>>>>>> aaefbab012eb6a526b4464931cc7df289fd67b4a
		    });
		});

})(window.angular);