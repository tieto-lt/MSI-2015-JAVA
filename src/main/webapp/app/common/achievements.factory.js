(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('AchievementsFactory', AchievementsFactory);
	
	AchievementsFactory.$inject = ['$http'];
	
	function AchievementsFactory($http) {
		
		return {
			claim: claim
		};
		
		function claim(userId, achievementId, points) {
			var transferObject = {
				userId: userId,
				achievementId: achievementId,
				points: points
			}
			console.log(transferObject);
			return $http.post('api/claim', transferObject);
			
		}
		
	}
})();