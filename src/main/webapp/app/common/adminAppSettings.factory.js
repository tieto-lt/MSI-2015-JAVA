(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('AdminAppSettingsFactory', AdminAppSettingsFactory);
	
	AdminAppSettingsFactory.$inject = ['$http'];
	
	function AdminAppSettingsFactory($http) {
		
//		var data = [];
		
//	    function leaders(){
	    	
//	    	$http
//		      .get('leaderboard')
//		      .then(function(response) {
//		        angular.extend(data, response.data);
//		    });
//		    
//		    return data;
//	    }
//	    return {
//	    	leaders: leaders
//	    }
		return ""
	}
	
})();