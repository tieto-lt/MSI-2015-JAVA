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

	function changePage(state) {
	      vm.currentPage = state;
	      $state.go(state);
	}

	function changePageWithParams(state, params) {
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