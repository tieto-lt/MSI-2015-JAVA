(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('PointsTransferFactory', PointsTransferFactory);
	
	PointsTransferFactory.$inject = ['$http'];
	
	function PointsTransferFactory($http) {
		
		return {
			sendPoints: sendPoints
	    };

	    /**
	     * Sends a POST request to 'points/send' route in server
	     */
	    function sendPoints(transferInfo) {
	    	return $http
	    	  .post('points/send', transferInfo);
	    }
	}
	
})();