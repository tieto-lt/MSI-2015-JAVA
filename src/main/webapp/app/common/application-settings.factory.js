(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('ApplicationSettingsFactory', ApplicationSettingsFactory);
	
	ApplicationSettingsFactory.$inject = ['$http'];
	
	function ApplicationSettingsFactory($http) {
		
		var data = [];
		
		return {
			getApplicationSettings: getApplicationSettings,
			getOneTimeLimit: getOneTimeLimit
	    };

	    function getApplicationSettings() {
	    	return $http
	    	  .get('applicationSettings');
	    }
	    
	    function getOneTimeLimit() {
	    	return getApplicationSettings().then(function (response) {
	    		var oneTimeLimit = 'test';
	    		angular.forEach(response.data, function(setting) {
		    		
		    		if (setting['property'] === 'one_time_limit')
		    			oneTimeLimit = setting['value'];
		    	});
	    		
	    		return oneTimeLimit;
	    	});
	    }
	}
	
})();