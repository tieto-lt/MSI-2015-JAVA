(function () {
  'use strict';
  
  angular
  	.module('app.logout')
  	.controller('LogoutController', LogoutController);
  
  LogoutController.$inject = ['LogoutFactory', '$state', 'ProfileHeaderFactory'];
  
  
  function LogoutController(LogoutFactory, $state, ProfileHeaderFactory) {
	  var vm = this;
	  
	  vm.logout = logout;
	  
	  function logout() {
		  LogoutFactory.logout();
		  $state.go('login');
		  ProfileHeaderFactory.clearUserInformation();
	  }
	  
	  
  }
  
})(window.angular);