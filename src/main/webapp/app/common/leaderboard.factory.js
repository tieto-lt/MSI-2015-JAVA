(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('LeaderboardFactory', LeaderboardFactory);
	
	LeaderboardFactory.$inject = ['$http'];
	
	function LeaderboardFactory() {
	    /*
	     * return array of leaders
	     */
	    function leaders(){
	    	return [
	           {
	        	   position: 1,
	        	   name: "Marius",
	        	   points: 3000
	           },
	           {
	        	   position: 1,
	        	   name: "Vincas",
	        	   points: 2352
	           },
	           {
	        	   position: 1,
	        	   name: "Leo",
	        	   points: 5322
	           },
	           {
	        	   position: 1,
	        	   name: "Mykolas",
	        	   points: 7655
	           },
	           {
	        	   position: 1,
	        	   name: "Marius3",
	        	   points: 4214
	           }
	        ]
	    }
	    
	    return {
	    	leaders: leaders
	    }
	}
	
})();