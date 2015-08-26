(function (angular) {
  'use strict';

  angular
    .module('app.profileHeader')
    .controller('ProfileHeaderController', ProfileHeaderController);

  ProfileHeaderController.$inject = ['ProfileHeaderFactory'];

  function ProfileHeaderController(ProfileHeaderFactory) {
    var vm = this;

    vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    vm.showProfileImage = showProfileImage;
    vm.getProfileInfo = getProfileInfo;
    	
    function getProfileInfo() {
    	vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    }
    
    function showProfileImage(image) {
    	if (image) {
    		return atob(image);
    	}
    	else {
    		return 'assets/images/no-profile-pic.png';
    	}
    		
    }
    
  }
  

})(window.angular);