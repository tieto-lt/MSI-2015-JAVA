(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('PointsTransferFactory', PointsTransferFactory);
	
	PointsTransferFactory.$inject = ['$http'];
	
	function PointsTransferFactory($http) {
		var data = [];
		
		//TODO nereikia nieko inicializuot tam data??
		
		return {
			sendPoints: sendPoints
	    };

	    /**
	     * Sends a POST request to 'points/send' route in server
	     */
	    function sendPoints(transferInfo) {
	    	$http
	    	  .post('points/send', transferInfo)
	          .then(function(response) {
	        	  data.push(response.data);
	          });
	    }
	}
})();