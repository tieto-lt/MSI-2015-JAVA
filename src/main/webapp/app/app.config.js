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
		    	templateUrl: "adminPage.tmpl.html",
		    	resolve: {
		            security: ['$q', 'ProfileHeaderFactory',  function($q, ProfileHeaderFactory){
		                if(!ProfileHeaderFactory.getProfileInfo().role) {
		                	return ProfileHeaderFactory.loadUserInfo().then(function() {
		                		if(!ProfileHeaderFactory.isAdminUser()){
		 		                   return $q.reject("Not Authorized");
		 		                }    
		                	}, function error() {
	 		                   return $q.reject("Not Authorized");
		                	})
		                } else {
		                	if(!ProfileHeaderFactory.isAdminUser()){
	 		                   return $q.reject("Not Authorized");
	 		                }
		                }
		            }]
		         }
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
		    .state('adminPage.shop', {
		    	url: "/adminShop",
		    	templateUrl: "app/adminShop/adminShop.tmpl.html"
		    })
		    .state('adminPage.addItem', {
		    	url: "/addItem",
		    	templateUrl: "app/adminShopAddItem/adminShopAddItem.tmpl.html"
		    })
		    .state('adminPage.editItem', {
		    	url: "/editItem/:id",
		    	templateUrl: "app/adminShopEditItem/adminShopEditItem.tmpl.html"
		    })
		    .state('userPage', {
		    	url: "/user",
		    	templateUrl: "userPage.tmpl.html",
		    	resolve: {
		            security: ['$q', 'ProfileHeaderFactory',  function($q, ProfileHeaderFactory){
		                if(!ProfileHeaderFactory.getProfileInfo().role) {
		                	return ProfileHeaderFactory.loadUserInfo().then(function success() {
		                		if(!ProfileHeaderFactory.isLoggedInUser()){
		 		                   return $q.reject("Not Authorized");
		 		                }
		                	}, function error() {
	 		                   return $q.reject("Not Authorized");
		                	})
		                } else {
		                	if(!ProfileHeaderFactory.isLoggedInUser()){
	 		                   return $q.reject("Not Authorized");
	 		                }
		                }
		            }]        
		         }    
		    })
		    .state('userPage.profile', {
		    	url: "/userProfile/:id",
		    	templateUrl: "app/userProfile/userProfile.tmpl.html"
		    })
		    .state('userPage.profile.newsfeed', {
		    	url: "/userProfile/newsfeed",
		    	templateUrl: "app/newsFeedCurrUser/newsFeedCurrUser.tmpl.html"
		    })
		    .state('userPage.profile.purchaseHistory', {
		    	url: "/userProfile/purchaseHistory",
		    	templateUrl: "app/userPurchaseHistory/userPurchaseHistory.tmpl.html"
		    })
		    .state('userPage.shop', {
		    	url: "/userShop",
		    	templateUrl: "app/userShop/userShop.tmpl.html"
		    })
		    .state('userPage.item', {
		    	url: "/item/:id",
		    	templateUrl: "app/itemDescription/itemDescription.tmpl.html"
		    })
		    .state('userPage.home', {
		    	url: "/userHome",
		    	templateUrl: "app/userHome/userHome.tmpl.html"
		    })
			.state('logout', {
		    	url: "/logout",
		    	templateUrl: "loginPage.tmpl.html"
		    });
			
	});

})(window.angular);