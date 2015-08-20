(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('UserNewsFeedFactory', UserNewsFeedFactory);

  UserNewsFeedFactory.$inject = ['$http'];
  
  function UserNewsFeedFactory($http) {
	  
	  
	return {
		getNewsFeed: getNewsFeed
	};
		  
		    
	function getNewsFeed(id){
		
		var data = []
		
		$http.get('api/profileNewsfeed/' + id.toString()).then(function(response) {
	        angular.extend(data, response.data);
		});
		
		return data;
	}
	
  
  }
  
})();