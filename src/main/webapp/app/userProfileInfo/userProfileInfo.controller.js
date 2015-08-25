(function (){
	'use strict';

	angular
		.module('app.userProfileInfo')
		.controller('UserProfileInfoController', UserProfileInfoController);
	
	UserProfileInfoController.$inject = ['UsersFactory', 'ProfileHeaderFactory', 'UserNewsFeedFactory',
	                                     	'$state'];
	
	function UserProfileInfoController(UsersFactory, ProfileHeaderFactory, UserNewsFeedFactory,
			$state) {

		var vm = this;
		var currUserData = ProfileHeaderFactory.getProfileInfo();
		vm.currUserData = ProfileHeaderFactory.getProfileInfo();
		vm.profileId = $state.params.id;
		vm.givingPointsBlock = UsersFactory.givingPointsBlock;
		vm.responseMessages = UsersFactory.responseMessages;
		
		UsersFactory.unsetErrorMessages();
		UsersFactory.unsetGivingPointsBlock();
		
		vm.edit = edit;
		vm.saveChanges = saveChanges;
		vm.goToGivingPoints = goToGivingPoints;
		
		function edit() {
			vm.editBlock = true;
		}
		
		function goToGivingPoints() {
			vm.givingPointsBlock.shown = true;
		}
		
		function saveChanges() {
			vm.editBlock = '';
			var f = document.getElementById('edit-profile-photo').files[0];
			if (f) {
				var r = new FileReader();
				
				vm.user.imageName = f.name;
				vm.user.imageType = f.type;
			
				r.onload = function(e) {
					vm.user.image = e.target.result;
					// send you binary data via $http or $resource or do anything
					// else with it
					UsersFactory.updateUserProfile(vm.user).then(function() {
						UserNewsFeedFactory.updateNewsFeed(currUserData.id);
						ProfileHeaderFactory.loadUserInfo();
					});
	
				}
				r.readAsDataURL(f);
			} else {
				UsersFactory.updateUserProfile(vm.user).then(function() {
					UserNewsFeedFactory.updateNewsFeed(currUserData.id);
					ProfileHeaderFactory.loadUserInfo();
				});
			}
			
		}
		
		

		UsersFactory.getUserProfile(vm.profileId).then(function(response) {
			vm.user = response.data;
			if(response.data.image) {
				vm.user.image = atob(response.data.image);
			} else {
				vm.user.image = 'assets/images/no-profile-pic.png';
				vm.user.imageType = 'image/png';
				vm.user.imageName = 'no-profile-pic.png';
			}
			
			
			/*if (vm.user.aboutMe == null) {
				vm.user.aboutMe = 'Write something about yourself!';
			}*/
		});
	}
})();