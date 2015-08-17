(function (angular) {
  'use strict';

  angular
    .module('app.profileHeader')
    .controller('ProfileHeaderController', ProfileHeaderController);

  ProfileHeaderController.$inject = ['ProfileHeaderFactory', '$state'];

  function ProfileHeaderController(ProfileHeaderFactory, $state) {
    var vm = this;

    vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    //////////////////////////////////
    
    vm.changePage = changePage;
	vm.currentPage = $state.current.name;
    
    function changePage(state) {
    	 vm.currentPage = state;
		 $state.go(state);
	  }
    
    vm.getProfileInfo = function() {
    	vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    }
  }
  

})(window.angular);