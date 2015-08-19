(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('ItemDescriptionFactory', ItemDescriptionFactory);
	
	ItemDescriptionFactory.$inject = ['$http'];
	
	function ItemDescriptionFactory($http) {
		
		return {
			buy: buy
	    };

	    /**
	     * Sends a POST request to 'points/send' route in server
	     */
	    function buy(userId, shopItemId) {
	    	var transfer = {
	    		userId: userId,
	    		shopItemId: shopItemId
	    	}
	    	return $http
	    	  .post('api/buy', transfer);
	    }
	}
	
})();