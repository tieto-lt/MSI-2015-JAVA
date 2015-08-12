(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('AdminAppSettingsFactory', AdminAppSettingsFactory);
	
	AdminAppSettingsFactory.$inject = ['$http'];
	
	function AdminAppSettingsFactory($http) {
		
		var data = [];
		
		return {
			getApplicationSettings: getApplicationSettings,
			getOneTimeLimit: getOneTimeLimit,
			saveSettings: saveSettings
	    };

	    function getApplicationSettings() {
	    	return $http
	    	  .get('api/applicationSettings');
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
	    
	    function saveSettings(transferInfo) {
	    	var transferObject = [
	    	    {
	    	    	property:'MONTHLY_LIMIT',
	    	    	value: transferInfo.monthlyLimit
	    	    },
	    	    {
	    	    	property:'ONE_TIME_LIMIT',
	    	    	value: transferInfo.oneTimePointsLimit
	    	    }]
		    return $http
		    	.post('api/applicationSettings/save', transferObject);
	    }
	}
	
})();