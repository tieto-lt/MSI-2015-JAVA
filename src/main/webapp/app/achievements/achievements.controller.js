(function(angular) {
	'use strict';

	angular.module('app.adminAppSettings').controller(
			'AchievementsController', AchievementsController);

	AchievementsController.$inject = ['StatisticsFactory', 'ProfileHeaderFactory'];

	function AchievementsController(StatisticsFactory, ProfileHeaderFactory) {
		var vm = this;
		
		vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
		
		StatisticsFactory.getUserStatistics(vm.profileInfo.id).then(function(response) {
			vm.userStatistics = response.data;
		});
		
		
		
	}
})(window.angular);