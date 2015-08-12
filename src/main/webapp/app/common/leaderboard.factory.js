(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('LeaderboardFactory', LeaderboardFactory);
	
	LeaderboardFactory.$inject = ['$http'];
	
	function LeaderboardFactory($http) {
		
		var data = [];
		
	    function leaders(){
	    	
	    	$http
		      .get('api/leaderboard')
		      .then(function(response) {
		        angular.extend(data, response.data);
		    });
		    
		    return data;
	    }
	    return {
	    	leaders: leaders
	    }
	}
	
})();