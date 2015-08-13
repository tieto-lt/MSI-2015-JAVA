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
  	.config(function($locationProvider, $stateProvider, $urlRouterProvider) {

  		$urlRouterProvider.otherwise("/login");
//  		$locationProvider.html5Mode({
//  		  enabled: true,
//  		  requireBase: false
//  		});

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
		    .state('adminPage.applicationSettings', {
		    	url: "/applicationSettings",
		    	templateUrl: "app/adminAppSettings/adminAppSettings.tmpl.html"
		    })
		    .state('adminPage.shopSettings', {
		    	url: "/shopSettings",
		    	templateUrl: "app/adminShopSettings/adminShopSettings.tmpl.html"
		    })
		    .state('adminPage.valueGroupsSettings', {
		    	url: "/valueGroupsSettings",
		    	templateUrl: "app/adminValueGroupsSettings/adminValueGroupsSettings.tmpl.html"
		    })
		    .state('userPage', {
		    	url: "/user",
		    	templateUrl: "userPage.tmpl.html",
		    	resolve: {
		            security: ['$q, ProfileHeaderFactory',  function($q, ProfileHeaderFactory){
		                if(ProfileHeaderFactory.getUserData().length == 0){
		                   return $q.reject("Not Authorized");
		                }
		            }]
		         }
		    })
			.state('logout', {
		    	url: "/logout",
		    	templateUrl: "loginPage.tmpl.html"
		    });
	});

})(window.angular);