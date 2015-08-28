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
    vm.changePageIfWithParams = changePageIfWithParams;
    vm.profileId = $state.params.id;

	function changePage(state) {
	      vm.currentPage = state;
	      $state.go(state);
	}

	function changePageWithParams(state, params) {
		if(state=="userPage.profile.newsfeed") {
			if (params.id == 0) {
				return;
			}
	    	vm.profileId = params.id;
	    }
		vm.currentPage = state;
	    $state.go(state, params);
	    
	}
	
	function changePageIfWithParams(state, condition, params) {
		if (condition) {
			vm.changePageWithParams(state, params);
			vm.searchText = '';
		}
	}
}
  

})(window.angular);