(function (){
	'use strict';

	angular
		.module('app.userProfileInfo')
		.controller('UserProfileInfoController', UserProfileInfoController);
	
	UserProfileInfoController.$inject = ['UsersFactory', 'ProfileHeaderFactory'];
	
	function UserProfileInfoController(UsersFactory, ProfileHeaderFactory) {

		var vm = this;
		var currUserData = ProfileHeaderFactory.getProfileInfo();
		
		vm.user = {
	      photo: 'assets/images/no-profile-pic.png',
	    };

		UsersFactory.getUserProfile(currUserData.id).then(function(response) {
			vm.user = response.data;
			console.log(vm.user.aboutMe);
			
			if (vm.user.aboutMe == null) {
				vm.user.aboutMe = 'Write something about yourself!';
			}
		});
	}
})();