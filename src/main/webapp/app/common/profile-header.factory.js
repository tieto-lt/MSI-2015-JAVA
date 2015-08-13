(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('ProfileHeaderFactory', ProfileHeaderFactory);
	
	ProfileHeaderFactory.$inject = ['$http'];
	
	function ProfileHeaderFactory($http) {
		
		var data = [];
		
	    function getProfileInfo(){
	    	
	    	$http
		      .get('/api/user/getCurrentUser')
		      .then(function(response) {
		        angular.extend(data, response.data);
		    });
		    
		    return data;
	    }
	    return {
	    	getProfileInfo: getProfileInfo
	    }
	}
	
})();