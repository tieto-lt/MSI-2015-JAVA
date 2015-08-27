(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('NewsFeedFactory', NewsFeedFactory);

  NewsFeedFactory.$inject = ['$http', '$filter'];
  
  function NewsFeedFactory($http, $filter) {
	  
	var newsFeed = [];
	var shownNewsFeed = [];
	
	updateNewsFeed();
	  
	return {
	    updateNewsFeed: updateNewsFeed,
	    newsFeed: newsFeed,
	    getNewsFeedCurrUser: getNewsFeedCurrUser,
	    shownNewsFeed: shownNewsFeed,
	    loadMoreNews: loadMoreNews
	};
		  
	function updateNewsFeed(){
		return $http.get('api/newsfeed').then(function(response) {
			shownNewsFeed.length = 0;
			newsFeed.length = 0;
			angular.forEach(response.data, function(record){
	        	if(record.fromImage) {
	        		record.fromImage = atob(record.fromImage);
	        	} else if (record.category.name === 'Achievement') {
	        		record.fromImage = 'assets/images/achievements/cup.png';
	        	}
	        	else {
	        		record.fromImage = 'assets/images/no-profile-pic.png';
	        	}
	        	if(record.toImage) {
	        		record.toImage = atob(record.toImage);
	        	} else {
	        		record.toImage = 'assets/images/no-profile-pic.png';
	        	}
	        	
	        });
	        angular.extend(newsFeed, $filter('orderBy')(response.data, 'dateFull', true));
	        loadMoreNews();
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
	}

function loadMoreNews() {
    	var loaded = newsFeed.slice(shownNewsFeed.length, shownNewsFeed.length + 10);
    	shownNewsFeed.push.apply(shownNewsFeed, loaded);
    }
  
  }
  
  })();