(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('StatisticsFactory', StatisticsFactory);

  StatisticsFactory.$inject = ['$http'];

  function StatisticsFactory($http) {
	  
    return {
    	getStatistics: getStatistics,
    	getUserStatistics: getUserStatistics
    };
    
    
	function getStatistics() {
    	
    	return $http
	      .get('/statistics');
    }    
	
	function getUserStatistics(id) {
		
		return $http.get('api/statistics/' + id);
	}
	
  }

})();