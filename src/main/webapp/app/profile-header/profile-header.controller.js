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
    
    vm.shopItems = shopItems;
    
    function shopItems() {
		  $state.go('shopItems');
	  }
    
    vm.getProfileInfo = function() {
    	vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    }
  }
  

})(window.angular);