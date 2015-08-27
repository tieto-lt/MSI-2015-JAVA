(function(angular) {
	'use strict';

	angular.module('app.achievements').controller(
			'AchievementsController', AchievementsController);

	AchievementsController.$inject = ['StatisticsFactory', 'ProfileHeaderFactory',
	                                  'AdminAppSettingsFactory', 'AchievementsFactory'];

	function AchievementsController(StatisticsFactory, ProfileHeaderFactory, AdminAppSettingsFactory,
					AchievementsFactory) {
		var vm = this;
		
		vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
		
		vm.claimTrasfersMade = false;
		vm.claimTransfersGotten = false;
		vm.claimPointsGotten = false;
		
		vm.claim = claim;
		
		AdminAppSettingsFactory.getMonthlyLimit().then(function(response) {
			
			vm.monthlylimit = response;
			vm.getPointsAchievement = vm.monthlylimit * 0.25;
			vm.firstAchievementReward = vm.monthlylimit * 0.05;
			vm.secondAchievementReward = vm.monthlylimit * 0.05;
			vm.thirdAchievementReward = vm.monthlylimit * 0.075;
			
			StatisticsFactory.getUserStatistics(vm.profileInfo.id).then(function(response) {
				vm.userStatistics = response.data;
				
				console.log(vm.userStatistics.achievement_1);
				
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
		
		function claim(achievementId, achievementReward) {
			
			AchievementsFactory.claim(vm.profileInfo.id, achievementId, achievementReward);
			switch (achievementId) {
			case 1:
				vm.userStatistics.achievement_1 = true;
				break;
			case 2:
				vm.userStatistics.achievement_2 = true;
				break;
			case 3:
				vm.userStatistics.achievement_3 = true;
				break;
			}
			
		}
		
		
	}
})(window.angular);