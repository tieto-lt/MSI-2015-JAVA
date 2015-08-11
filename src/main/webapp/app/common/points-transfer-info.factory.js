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
	    	var transfer = {
    			fromUser: transferInfo.fromUser,
    			toUser: transferInfo.toUser.firstName + " " + transferInfo.toUser.lastName,
    			points: transferInfo.points,
    			comment: transferInfo.comment
	    	}
	    	return $http
	    	  .post('points/send', transfer);
	    }
	}
	
})();