(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('StatisticsFactory', StatisticsFactory);

  StatisticsFactory.$inject = ['$http'];

  function StatisticsFactory($http) {
	  
    return {
    	getStatistics: getStatistics
    };
    
    
	function getStatistics() {
    	
    	return $http
	      .get('/statistics');
    }    
	
  }

})();