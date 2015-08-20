(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('PointsTransferFactory', PointsTransferFactory);
	
	PointsTransferFactory.$inject = ['$http'];
	
	function PointsTransferFactory($http) {
		
    	var data = [];
		
		return {
			sendPoints: sendPoints,
			getTransfers: getTransfers,
			getNewsFeed: getNewsFeed
	    };

	    /**
	     * Sends a POST request to 'points/send' route in server
	     */
	    function sendPoints(transferInfo) {
	    	var transfer = {
    			toUserID: transferInfo.toUser.id,
    			points: transferInfo.points,
    			comment: transferInfo.comment
	    	}
	    	return $http
	    	  .post('api/points/send', transfer);
	    }
	    
	    function getTransfers(){
	    	
	    	return $http.get('api/points');
	    }
	    
	    function getNewsFeed(){
	    	
	    	
	    	$http.get('api/newsfeed').then(function(response) {
		        angular.extend(data, response.data);
	    	});
	    	
	    	return data;
	    }
	    
	}
	
})();