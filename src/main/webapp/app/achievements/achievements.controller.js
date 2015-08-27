(function(angular) {
	'use strict';

	angular.module('app.adminAppSettings').controller(
			'AchievementsController', AchievementsController);

	AchievementsController.$inject = ['StatisticsFactory', 'ProfileHeaderFactory', 'AdminAppSettingsFactory'];

	function AchievementsController(StatisticsFactory, ProfileHeaderFactory, AdminAppSettingsFactory) {
		var vm = this;
		
		vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
		
		vm.claimTrasfersMade = false;
		vm.claimTransfersGotten = false;
		vm.claimPointsGotten = false;
		
		AdminAppSettingsFactory.getMonthlyLimit().then(function(response) {
			
			vm.monthlylimit = response;
			vm.getPointsAchievement = vm.monthlylimit * 0.25;
			
			StatisticsFactory.getUserStatistics(vm.profileInfo.id).then(function(response) {
				vm.userStatistics = response.data;
				
				/*HARDCODED ACHIEVEMENTS*/
				if(vm.userStatistics.transfersMade >= 5) {
					vm.claimTrasfersMade = true;
				} else {
					vm.progressTrasfersMade = vm.userStatistics.transfersMade / 5 * 100;
				}
				
				if(vm.userStatistics.transfersGotten >= 5) {
					vm.claimTransfersGotten = true;
				} else {
					vm.progressTransfersGotten = vm.userStatistics.transfersGotten / 5 * 100;
				}
				
				if(vm.userStatistics.pointsGotten >= vm.getPointsAchievement) {
					vm.claimPointsGotten = true;
				} else {
					vm.progressPointsGotten = vm.userStatistics.pointsGotten / vm.getPointsAchievement * 100
				}
				
				console.log("transfers made:", vm.userStatistics.transfersMade, vm.claimTrasfersMade);
				console.log("transfers got:", vm.userStatistics.transfersGotten, vm.claimTransfersGotten);
				console.log("points got:", vm.userStatistics.pointsGotten, vm.claimPointsGotten);
				
			});
		});
		
		
		
		
		
		
	}
})(window.angular);