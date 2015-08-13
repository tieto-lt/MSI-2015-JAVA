(function () {
  'use strict';
  
  angular
  	.module('app.logout')
  	.controller('LogoutController', LogoutController);
  
  LogoutController.$inject = ['LogoutFactory', '$state'];
  
  
  function LogoutController(LogoutFactory, $state) {
	  var vm = this;
	  
	  vm.logout = logout;
	  
	  function logout() {
		  LogoutFactory.logout();
		  $state.go('login');
	  }
	  
	  
  }
  
})(window.angular);