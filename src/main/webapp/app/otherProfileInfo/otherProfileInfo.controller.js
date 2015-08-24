(function (angular){
	'use strict';

	angular
		.module('app.otherProfileInfo')
		.controller('OtherProfileInfoController', OtherProfileInfoController);
	
	OtherProfileInfoController.$inject = ['UsersFactory', '$stateParams'];
	
	function OtherProfileInfoController(UsersFactory, $stateParams) {

		var vm = this;
		
		if ($stateParams.id) {
			vm.id = $stateParams.id;
		}
		
		UsersFactory.getUserProfile(vm.id).then(function(response) {
			vm.user = response.data;
			if(response.data.image) {
				vm.user.image = atob(response.data.image);
			} else {
				vm.user.image = 'assets/images/no-profile-pic.png';
				vm.user.imageType = 'image/png';
				vm.user.imageName = 'no-profile-pic.png';
			}
		});

		vm.goToGivePoints = goToGivePoints;
		
		function goToGivePoints() {
			vm.givePointsBlock = 'go';
		}
		
	}
})(window.angular);