(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('NewsFeedFactory', NewsFeedFactory);

  NewsFeedFactory.$inject = ['$http'];
  
  function NewsFeedFactory($http) {
	  
	var newsFeed = [];
	
	updateNewsFeed();
	  
	return {
	    updateNewsFeed: updateNewsFeed,
	    newsFeed: newsFeed,
	    getNewsFeedCurrUser: getNewsFeedCurrUser
	};
		  
		    
	function updateNewsFeed(){
		$http.get('api/newsfeed').then(function(response) {
	        angular.extend(newsFeed, response.data);
		});
	}
	
	function getNewsFeed(){
		return newsFeed;
	}
	
	function getNewsFeedCurrUser(id){
		var data = {};
		
		data = $http({
					url: '/api/profileNewsfeed/' + id.toString(),
					method: "GET"	
		});
		
		return data;
		
//		$http.get('api/profileNewsfeed/' + id.toString()).then(function(response) {
//	        angular.extend(data, response.data);
//		});
//		
//		return data;
	}
  }
  
  })();