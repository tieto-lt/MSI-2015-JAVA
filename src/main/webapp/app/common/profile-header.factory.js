(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('ProfileHeaderFactory', ProfileHeaderFactory);
	
	ProfileHeaderFactory.$inject = ['$http'];
	
	function ProfileHeaderFactory($http) {
		
		var data = {};
		
	    function getProfileInfo(){
		    return data;
	    }
	    
	    function loadUserInfo(){
	    	
	    	return $http
		      .get('/api/user/getCurrentUser')
		      .then(function(response) {
		        angular.extend(data, response.data);
		    });
	    }
	    
	    function clearUserInformation() {
	    	data = {};
	    }
	    
	    function isLoggedInUser() {
	    	return data.role == 'USER';
	    }
	    
	    function isAdminUser() {
	    	return data.role == 'ADMIN';
	    }
	    
	    return {
	    	getProfileInfo: getProfileInfo,
	    	loadUserInfo: loadUserInfo,
	    	isLoggedInUser: isLoggedInUser,
	    	isAdminUser: isAdminUser,
	    	clearUserInformation: clearUserInformation
	    }
	}
	
})();