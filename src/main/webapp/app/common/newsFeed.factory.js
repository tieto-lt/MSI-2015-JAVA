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
	    newsFeed: newsFeed
	};
		  
		    
	function updateNewsFeed(){
		$http.get('api/newsfeed').then(function(response) {
	        angular.extend(newsFeed, response.data);
		});
	}
	
	function getNewsFeed(){
		return newsFeed;
	}
  
  }
  
  })();