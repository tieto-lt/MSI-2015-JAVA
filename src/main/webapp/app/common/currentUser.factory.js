(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('CurrentUserFactory', CurrentUserFactory);
	
	CurrentUserFactory.$inject = ['$http'];
	
	function CurrentUserFactory($http) {
		
		var currentUser = [];
		
		function getUser() {
	    	
	    	return $http
		      .get('api/user/getCurrentUser');
	    	
	    }
	}
	
})();