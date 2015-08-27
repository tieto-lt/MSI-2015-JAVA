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
		vm.user = UsersFactory.userProfile;
		vm.submitError = '';
		vm.submitSuccess = '';
		
		UsersFactory.refreshUserProfile(vm.profileId);
		
		UsersFactory.unsetErrorMessages();
		UsersFactory.unsetGivingPointsBlock();
		
		vm.edit = edit;
		vm.saveChanges = saveChanges;
		vm.goToGivingPoints = goToGivingPoints;
		vm.goToProfileBlock = goToProfileBlock;
		
		function edit() {
			vm.editBlock = true;
		}
		
		function goToGivingPoints() {
			vm.givingPointsBlock.shown = true;
		}
		
		function goToProfileBlock() {
			vm.givingPointsBlock.shown = false;
		}
		
		function saveChanges() {
			
			var f = document.getElementById('edit-profile-photo').files[0];
			
			var submit = function (user) {
				UsersFactory.updateUserProfile(vm.user).then(function() {
					UserNewsFeedFactory.updateNewsFeed(currUserData.id);
					ProfileHeaderFactory.loadUserInfo();
					user.newPassword = '';
					user.confirmPassword = '';
					user.oldPassword = '';
					vm.submitSuccess = 'Successfully updated password';
					vm.submitError = '';
					vm.editBlock = '';
				}, function() {
					vm.submitError = 'Incorrect password';
					vm.submitSuccess = '';
					user.oldPassword = '';
				});
			}
			
			if (f) {
				var r = new FileReader();
				
				vm.user.imageName = f.name;
				vm.user.imageType = f.type;
				r.onload = function(e) {
					vm.user.image = e.target.result;
					submit(vm.user)
				}
				r.readAsDataURL(f);
			} else {
				submit(vm.user);
			}
		}
		

		
		/*UsersFactory.getUserProfile(vm.profileId).then(function(response) {
			vm.user = response.data;
			if(response.data.image) {
				vm.user.image = atob(response.data.image);
			} else {
				vm.user.image = 'assets/images/no-profile-pic.png';
				vm.user.imageType = 'image/png';
				vm.user.imageName = 'no-profile-pic.png';
			}
		});*/
	}
})();