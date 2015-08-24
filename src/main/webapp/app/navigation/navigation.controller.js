(function (angular) {
  'use strict';

  angular
    .module('app.navigation')
    .controller('NavigationController', NavigationController);

  NavigationController.$inject = ['$state', 'ProfileHeaderFactory'];

  function NavigationController($state, ProfileHeaderFactory) {
    var vm = this;

    vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    ProfileHeaderFactory.loadUserInfo();
    
    vm.changePage = changePage;
    vm.currentPage = $state.current.name;
    vm.changePageWithParams = changePageWithParams;
    vm.goToOtherProfile = goToOtherProfile;

	function changePage(state) {
	      vm.currentPage = state;
	      $state.go(state);
	}

	function changePageWithParams(state, params) {
		vm.currentPage = state;
	    $state.go(state, params);
	}
	
	function goToOtherProfile(state, params) {
    	if(params.id === vm.profileInfo.id) {
    		vm.currentPage = "userPage.profile";
    		$state.go("userPage.profile");
    	} else {
    		vm.currentPage = state;
    		$state.go(state, params);
    	}
	}

    
}
  

})(window.angular);